package com.keronei.android.domain.usecases

interface BaseUseCase <in Params, out T> {
    operator fun invoke(params : Params) : T
}