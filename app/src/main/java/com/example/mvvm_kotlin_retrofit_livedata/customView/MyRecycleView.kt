package com.example.mvvm_kotlin_retrofit_livedata.customView

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MyRecycleView:RecyclerView {

    var stateViewState: RecyclerViewStateEnum? = RecyclerViewStateEnum.LOADING
        set(value) {
            field = value
            setState()
        }
    var emptyStateView: View? = null
    var loadingStateView: View? = null
    var errorStateView: View? = null


    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {}


    private val dataObserver = object : AdapterDataObserver() {
        override fun onChanged() {
            onChangeState()
        }

        override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
            super.onItemRangeRemoved(positionStart, itemCount)
            onChangeState()
        }

        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
            super.onItemRangeInserted(positionStart, itemCount)
            onChangeState()
        }
    }



    override fun setAdapter(adapter: RecyclerView.Adapter<*>?) {
        super.setAdapter(adapter)
        adapter?.registerAdapterDataObserver(dataObserver)
        dataObserver.onChanged()
    }


    fun onChangeState() {
        if (adapter?.itemCount == 0) {
            emptyStateView?.visibility = View.VISIBLE

            this@MyRecycleView.visibility = View.GONE
        } else {
            emptyStateView?.visibility = View.GONE
           if(this@MyRecycleView.visibility!=View.VISIBLE)
            this@MyRecycleView.visibility = View.VISIBLE
        }
        loadingStateView?.visibility = View.GONE
        errorStateView?.visibility = View.GONE
    }

    private fun setState() {

        when (this.stateViewState) {
            RecyclerViewStateEnum.LOADING -> {
                loadingStateView?.visibility = View.VISIBLE
                this@MyRecycleView.visibility = View.GONE
                emptyStateView?.visibility = View.GONE
                errorStateView?.visibility = View.GONE
            }

            RecyclerViewStateEnum.NORMAL -> {
                loadingStateView?.visibility = View.GONE
                this@MyRecycleView.visibility = View.VISIBLE
                emptyStateView?.visibility = View.GONE
                errorStateView?.visibility = View.GONE
            }
            RecyclerViewStateEnum.EMPTY_STATE -> {
                loadingStateView?.visibility = View.GONE
                this@MyRecycleView.visibility = View.GONE
                emptyStateView?.visibility = View.VISIBLE
                errorStateView?.visibility = View.GONE
            }
            RecyclerViewStateEnum.ERROR -> {
                loadingStateView?.visibility = View.GONE
                this@MyRecycleView.visibility = View.GONE
                emptyStateView?.visibility = View.GONE
                errorStateView?.visibility = View.VISIBLE
            }
        }
    }

    enum class RecyclerViewStateEnum {
        LOADING,
        NORMAL,
        EMPTY_STATE,
        ERROR
    }
}