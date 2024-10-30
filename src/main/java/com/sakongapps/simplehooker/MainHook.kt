package com.sakongapps.simplehooker

import com.sakongapps.simplehooker.simpleutils.BottomTabs
import com.sakongapps.simplehooker.simpleutils.LayoutRemover
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.callbacks.XC_LoadPackage

class MainHook : IXposedHookLoadPackage {

    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        // 检查是否加载了目标应用包 com.huawei.health
        if (lpparam.packageName != "com.huawei.health") {
            return
        }

        XposedBridge.log("Loaded app: ${lpparam.packageName}")

        BottomTabs.hideMemberButton(lpparam)

        LayoutRemover.hookLayoutRemoval(lpparam)
    }
}
