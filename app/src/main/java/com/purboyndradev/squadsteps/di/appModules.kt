package com.purboyndradev.squadsteps.di

import androidx.credentials.CredentialManager
import com.purboyndradev.squadsteps.BuildConfig
import com.purboyndradev.squadsteps.data.datasources.PasskeysRemoteDataSource
import com.purboyndradev.squadsteps.data.datasources.UsersRemoteDataSource
import com.purboyndradev.squadsteps.data.network.api.KtorPasskeysApi
import com.purboyndradev.squadsteps.data.network.api.KtorUsersAPi
import com.purboyndradev.squadsteps.data.network.api.PasskeysApi
import com.purboyndradev.squadsteps.data.network.api.UsersApi
import com.purboyndradev.squadsteps.data.repositories.PasskeysRepositoryImpl
import com.purboyndradev.squadsteps.data.repositories.UsersRepositoryImpl
import com.purboyndradev.squadsteps.data.services.AndroidPasskeyService
import com.purboyndradev.squadsteps.data.services.PreferenceService
import com.purboyndradev.squadsteps.domain.repositories.PasskeysRepository
import com.purboyndradev.squadsteps.domain.repositories.UsersRepository
import com.purboyndradev.squadsteps.domain.services.PasskeyService
import com.purboyndradev.squadsteps.features.login.LoginViewModel
import org.koin.dsl.module
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.json.Json
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.logging.*
import io.ktor.http.HttpHeaders
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel

val appModules = module {

    single {
        HttpClient(CIO) {

            println("BASE URL: ${BuildConfig.BASE_URL}")

            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                    isLenient = true
                })
            }
            install(Logging) {
                logger = Logger.ANDROID
                level = LogLevel.ALL
            }
            defaultRequest {
                url(BuildConfig.BASE_URL)
                contentType(ContentType.Application.Json)
            }
        }
    }

    single { CredentialManager.create(androidContext()) }

    single<PasskeyService> {
        AndroidPasskeyService(
            context = androidContext(),
            credentialManager = get()
        )
    }
    single {
        PreferenceService(androidContext())
    }

    single<PasskeysApi> {
        KtorPasskeysApi(get())
    }
    single<UsersApi> {
        KtorUsersAPi(get())
    }

    single {
        PasskeysRemoteDataSource(get())
    }
    single {
        UsersRemoteDataSource(get())
    }

    single<PasskeysRepository> {
        PasskeysRepositoryImpl(
            get()
        )
    }
    single<UsersRepository> {
        UsersRepositoryImpl(
            get(),
            get()
        )
    }

    viewModel {
        LoginViewModel(get(), get(), get())
    }
}