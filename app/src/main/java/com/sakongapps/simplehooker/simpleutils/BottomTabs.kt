package com.sakongapps.simplehooker.simpleutils

import android.content.Context
import android.util.AttributeSet
import android.view.MenuItem
import android.view.View
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage

object BottomTabs {

    fun hideMemberButton(lpparam: XC_LoadPackage.LoadPackageParam) {
        // Hook BottomNavigationItemView 的构造函数
        XposedHelpers.findAndHookConstructor(
            "com.huawei.uikit.hwbottomnavigationview.widget.HwBottomNavigationView\$BottomNavigationItemView",
            lpparam.classLoader,
            "com.huawei.uikit.hwbottomnavigationview.widget.HwBottomNavigationView",
            Context::class.java,
            MenuItem::class.java,
            Boolean::class.javaPrimitiveType,
            Int::class.javaPrimitiveType,
            Boolean::class.javaPrimitiveType,
            AttributeSet::class.java,
            Int::class.javaPrimitiveType,
            object : XC_MethodHook() {
                override fun afterHookedMethod(param: MethodHookParam) {
                    // 获取 BottomNavigationItemView 的 MenuItem
                    val menuItem = param.args[2] as? MenuItem
                    if (menuItem?.title == "会员") {
                        XposedBridge.log("Found '会员' menu item, hiding BottomNavigationItemView")
                        // 隐藏整个 BottomNavigationItemView
                        val bottomNavItemView = param.thisObject as View
                        bottomNavItemView.visibility = View.GONE
                    }
                }
            }
        )
    }
}
