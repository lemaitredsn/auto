package ru.lemaitre.auto.features.search.all.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import kotlinx.android.extensions.LayoutContainer
import ru.lemaitre.auto.data.model.AdsModel

class AdsAdapterDelegate(private val onAdsClicked: () -> Unit):
    AbsListItemAdapterDelegate<AdsModel, AdsModel, AdsAdapterDelegate.AdsHolder>() {

    class AdsHolder(
        override val containerView: View,
        onAdsClicked: () -> Unit
    ): RecyclerView.ViewHolder(containerView), LayoutContainer{

        init {
            //todo add click listener
        }

        fun bind(ads: AdsModel){

        }
    }

    override fun isForViewType(
        item: AdsModel,
        items: MutableList<AdsModel>,
        position: Int
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup): AdsHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(item: AdsModel, holder: AdsHolder, payloads: MutableList<Any>) {
        TODO("Not yet implemented")
    }
}