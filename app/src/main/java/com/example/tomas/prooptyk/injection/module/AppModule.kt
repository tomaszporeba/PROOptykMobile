package com.example.tomas.prooptyk.injection.module

import android.app.Application
import android.arch.persistence.room.Room
import com.example.tomas.prooptyk.data.ProOptykDatabase
import com.example.tomas.prooptyk.data.UserResponseDao
import com.example.tomas.prooptyk.network.ApiService
import com.example.tomas.prooptyk.utils.BASE_URL
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by tomas on 13.08.2018.
 */
@Module
class AppModule {


    @Provides
    @Singleton
    fun provideProOptykDatabase(app: Application): ProOptykDatabase = Room.databaseBuilder(app,
            ProOptykDatabase::class.java, "prooptyk_database")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideUserResponseDao(proOptykDatabase: ProOptykDatabase): UserResponseDao = proOptykDatabase.userResponseDao()



    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    @Singleton
    fun provideCache(cacheFile: File): Cache {
        return Cache(cacheFile, 10*1024*1024)
    }

    @Provides
    @Singleton
    fun provideFile(application: Application): File {
        return File(application.cacheDir, UUID.randomUUID().toString())
    }

    @Provides
    @Singleton
    fun provideokHttpClient(cache: Cache, interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .cache(cache)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build()
    }

    @Provides
    @Singleton
    fun provideApiService(gson: Gson ,okHttpClient: OkHttpClient ): ApiService {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build().create(ApiService::class.java)
    }


}