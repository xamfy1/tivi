/*
 * Copyright 2017 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package app.tivi.util

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.experimental.Job

/**
 * Simple ViewModel which exposes a [CompositeDisposable] and [Job] which are automatically cleared/stopped when
 * the ViewModel is cleared.
 */
open class TiviViewModel : ViewModel(), ITiviViewModel {
    override val job = Job()
    override val disposables = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
        job.cancel()
    }
}