package com.MigrationModule

import com.facebook.react.TurboReactPackage
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.NativeModule
import com.facebook.react.uimanager.ViewManager
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.module.model.ReactModuleInfo;

import com.MigrationModule.MigrationModuleModule

class MigrationModulePackage : TurboReactPackage() {

    override fun getModule(name: String, ctx: ReactApplicationContext): NativeModule? {
        if (name.equals(MigrationModuleModule.NAME)) {
            return MigrationModuleModule(ctx);
        } else {
            return null
        }
    }

    override fun getReactModuleInfoProvider(): ReactModuleInfoProvider {

        class Provider: ReactModuleInfoProvider {

            override fun getReactModuleInfos(): Map<String, ReactModuleInfo> {
                val moduleInfos = mutableMapOf<String, ReactModuleInfo>();
                moduleInfos.put(
                    MigrationModuleModule.NAME,
                    ReactModuleInfo(
                        MigrationModuleModule.NAME,
                        MigrationModuleModule.NAME,
                        false, // canOverrideExistingModule
                        false, // needsEagerInit
                        true, // hasConstants
                        false, // isCxxModule
                        true // isTurboModule
                    ));
                return moduleInfos;
            }

        }

        return Provider();
    }
}