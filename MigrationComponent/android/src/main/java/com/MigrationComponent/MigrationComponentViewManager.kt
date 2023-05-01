package com.MigrationComponent

import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewManagerDelegate
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.MigrationComponentManagerInterface
import com.facebook.react.viewmanagers.MigrationComponentManagerDelegate

import com.facebook.react.uimanager.ViewGroupManager

@ReactModule(name = MigrationComponentViewManager.NAME)
class MigrationComponentViewManager : ViewGroupManager<MigrationComponentView>(),
MigrationComponentManagerInterface<MigrationComponentView> {
  private val mDelegate: ViewManagerDelegate<MigrationComponentView>

  init {
    mDelegate = MigrationComponentManagerDelegate(this)
  }

  override fun getDelegate(): ViewManagerDelegate<MigrationComponentView>? {
    return mDelegate
  }

  override fun getName(): String {
    return NAME
  }

  public override fun createViewInstance(context: ThemedReactContext): MigrationComponentView {
    return MigrationComponentView(context)
  }

  @ReactProp(name = "text")
  override fun setText(view: MigrationComponentView?, text: String?) {
    //
  }

  companion object {
    const val NAME = "MigrationComponent"
  }
}