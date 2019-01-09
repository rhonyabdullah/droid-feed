package com.droidfeed.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.droidfeed.ui.adapter.diff.Diffable

/**
 * Base UI model to be used with [UiModelAdapter].
 */
abstract class BaseUiModel<T : RecyclerView.ViewHolder> {

    abstract fun getViewHolder(parent: ViewGroup): T

    abstract fun bindViewHolder(viewHolder: T)

    abstract fun getViewType(): Int

    abstract fun getData(): Diffable
}