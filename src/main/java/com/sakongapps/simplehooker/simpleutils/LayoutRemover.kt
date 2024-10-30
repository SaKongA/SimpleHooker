package com.sakongapps.simplehooker.simpleutils

import android.view.ViewGroup
import android.widget.LinearLayout
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage

object LayoutRemover {

    fun hookLayoutRemoval(lpparam: XC_LoadPackage.LoadPackageParam) {
        // Hook ViewGroup 的 onAttachedToWindow 方法
        XposedHelpers.findAndHookMethod(
            ViewGroup::class.java,
            "onAttachedToWindow",
            object : XC_MethodHook() {
                override fun afterHookedMethod(param: MethodHookParam) {
                    val viewGroup = param.thisObject as? LinearLayout ?: return
                    removeVipLayout(viewGroup)
                    removeDeviceVmallCardLayout(viewGroup)
                    removeMarketingGridLayout(viewGroup)
                    removeMarketingGridSubHearderLayout(viewGroup)
                    removeOperationCardLayout(viewGroup)
                    removeVipStateIcon(viewGroup)
                    removeItemChannelRedPoint(viewGroup)
                    removeRankView(viewGroup)
                    removeMymedalRedPoint(viewGroup)
                    removeListContentRedPoint(viewGroup)
                    removeRlGone(viewGroup)
                }
            }
        )
    }

    // 移除我的页面会员条幅
    private fun removeVipLayout(linearLayout: LinearLayout) {
        val vipLayoutId = linearLayout.resources.getIdentifier("vip_layout", "id", linearLayout.context.packageName)

        for (i in 0 until linearLayout.childCount) {
            val child = linearLayout.getChildAt(i)
            if (child.id == vipLayoutId) {
                linearLayout.removeView(child)
                XposedBridge.log("vip_layout removed successfully from LinearLayout")
                return
            }
        }
    }

    // 移除设备中心的华为商城
    private fun removeDeviceVmallCardLayout(linearLayout: LinearLayout) {
        val deviceVmallCardLayoutId = linearLayout.resources.getIdentifier("device_vmall_card_layout", "id", linearLayout.context.packageName)

        for (i in 0 until linearLayout.childCount) {
            val child = linearLayout.getChildAt(i)
            if (child.id == deviceVmallCardLayoutId) {
                linearLayout.removeView(child)
                XposedBridge.log("device_vmall_card_layout removed successfully from LinearLayout")
                return
            }
        }
    }

    // 移除首页服务推广按钮
    private fun removeMarketingGridLayout(linearLayout: LinearLayout) {
        val deviceMarketingGridLayoutId = linearLayout.resources.getIdentifier("layout_marketing_grid", "id", linearLayout.context.packageName)

        for (i in 0 until linearLayout.childCount) {
            val child = linearLayout.getChildAt(i)
            if (child.id == deviceMarketingGridLayoutId) {
                linearLayout.removeView(child)
                XposedBridge.log("layout_marketing_grid removed successfully from LinearLayout")
                return
            }
        }
    }

    // 移除首页服务推广按钮消失后留下的更多选项卡
    private fun removeMarketingGridSubHearderLayout(linearLayout: LinearLayout) {
        val marketingGridSubHearderLayoutId = linearLayout.resources.getIdentifier("marketing_grid_sub_header", "id", linearLayout.context.packageName)

        for (i in 0 until linearLayout.childCount) {
            val child = linearLayout.getChildAt(i)
            if (child.id == marketingGridSubHearderLayoutId) {
                linearLayout.removeView(child)
                XposedBridge.log("marketing_grid_sub_header removed successfully from LinearLayout")
                return
            }
        }
    }

    // 移除首页底部推广
    private fun removeOperationCardLayout(linearLayout: LinearLayout) {
        val operationCardLayoutId = linearLayout.resources.getIdentifier("operation_card_layout", "id", linearLayout.context.packageName)

        for (i in 0 until linearLayout.childCount) {
            val child = linearLayout.getChildAt(i)
            if (child.id == operationCardLayoutId) {
                linearLayout.removeView(child)
                XposedBridge.log("operation_card_layout removed successfully from LinearLayout")
                return
            }
        }
    }

    // 移除我的页面VIP徽章
    private fun removeVipStateIcon(linearLayout: LinearLayout) {
        val vipStateIcon = linearLayout.resources.getIdentifier("vip_state_icon", "id", linearLayout.context.packageName)

        for (i in 0 until linearLayout.childCount) {
            val child = linearLayout.getChildAt(i)
            if (child.id == vipStateIcon) {
                linearLayout.removeView(child)
                XposedBridge.log("vip_state_icon removed successfully from LinearLayout")
                return
            }
        }
    }

    // 移除我的页面的部分无用红点
    private fun removeItemChannelRedPoint(linearLayout: LinearLayout) {
        val itemChannelRedPoint = linearLayout.resources.getIdentifier("item_channel_red_point", "id", linearLayout.context.packageName)

        for (i in 0 until linearLayout.childCount) {
            val child = linearLayout.getChildAt(i)
            if (child.id == itemChannelRedPoint) {
                linearLayout.removeView(child)
                XposedBridge.log("item_channel_red_point removed successfully from LinearLayout")
                return
            }
        }
    }

    // 移除我的页面的部分无用红点
    private fun removeRankView(linearLayout: LinearLayout) {
        val rankView = linearLayout.resources.getIdentifier("rank_view", "id", linearLayout.context.packageName)

        for (i in 0 until linearLayout.childCount) {
            val child = linearLayout.getChildAt(i)
            if (child.id == rankView) {
                linearLayout.removeView(child)
                XposedBridge.log("rank_view removed successfully from LinearLayout")
                return
            }
        }
    }

    // 移除我的页面的部分无用红点
    private fun removeMymedalRedPoint(linearLayout: LinearLayout) {
        val mymedalRedPoint = linearLayout.resources.getIdentifier("mymedal_red_point", "id", linearLayout.context.packageName)

        for (i in 0 until linearLayout.childCount) {
            val child = linearLayout.getChildAt(i)
            if (child.id == mymedalRedPoint) {
                linearLayout.removeView(child)
                XposedBridge.log("mymedal_red_point removed successfully from LinearLayout")
                return
            }
        }
    }

    // 移除我的页面列表中的无用红点
    private fun removeListContentRedPoint(linearLayout: LinearLayout) {
        val listContentRedPoint = linearLayout.resources.getIdentifier("list_content_red_point", "id", linearLayout.context.packageName)

        for (i in 0 until linearLayout.childCount) {
            val child = linearLayout.getChildAt(i)
            if (child.id == listContentRedPoint) {
                linearLayout.removeView(child)
                XposedBridge.log("list_content_red_point removed successfully from LinearLayout")
                return
            }
        }
    }

    // 移除我的页面中账户部分的等级和卡卡
    private fun removeRlGone(linearLayout: LinearLayout) {
        val rlGone = linearLayout.resources.getIdentifier("rl_gone", "id", linearLayout.context.packageName)

        for (i in 0 until linearLayout.childCount) {
            val child = linearLayout.getChildAt(i)
            if (child.id == rlGone) {
                linearLayout.removeView(child)
                XposedBridge.log("rl_gone removed successfully from LinearLayout")
                return
            }
        }
    }
}
