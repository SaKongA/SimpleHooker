package com.sakongapps.simplehooker.simpleutils

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.XposedHelpers

object LayoutRemover {

    fun hookLayoutRemoval() {
        // Hook ViewGroup 的 onAttachedToWindow 方法
        XposedHelpers.findAndHookMethod(
            ViewGroup::class.java,
            "onAttachedToWindow",
            object : XC_MethodHook() {
                override fun afterHookedMethod(param: MethodHookParam) {
                    val viewGroup = param.thisObject as ViewGroup  // 改为处理所有ViewGroup
                    if (viewGroup is LinearLayout) {  // 原有的移除操作保持不变
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
                    removeHealthHeadlinesCover(viewGroup)  // 对所有ViewGroup都尝试移除健康头条
                    removeAllMarketingAreas(viewGroup)
                    removeAllGoneLayouts(viewGroup)
                    removeAllMessageCountNew(viewGroup)
                    removeSportBanner(viewGroup)
                    removeSeriesCourseLayout(viewGroup)
                    removeDailyMomentLayout(viewGroup)
                }
            }
        )
    }

    // 移除我的页面会员条幅
    @SuppressLint("DiscouragedApi")
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
    @SuppressLint("DiscouragedApi")
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
    @SuppressLint("DiscouragedApi")
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
    @SuppressLint("DiscouragedApi")
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
    @SuppressLint("DiscouragedApi")
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
    @SuppressLint("DiscouragedApi")
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
    @SuppressLint("DiscouragedApi")
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
    @SuppressLint("DiscouragedApi")
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
    @SuppressLint("DiscouragedApi")
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
    @SuppressLint("DiscouragedApi")
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
    @SuppressLint("DiscouragedApi")
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

    // 修改健康头条移除方法
    @SuppressLint("DiscouragedApi")
    private fun removeHealthHeadlinesCover(viewGroup: ViewGroup) {
        val headlinesCoverId = viewGroup.resources.getIdentifier("health_headlines_cover", "id", viewGroup.context.packageName)
        
        fun findViewWithId(parent: ViewGroup): View? {
            for (i in 0 until parent.childCount) {
                val child = parent.getChildAt(i)
                if (child.id == headlinesCoverId) {
                    return child
                }
                if (child is ViewGroup) {
                    val result = findViewWithId(child)
                    if (result != null) {
                        return result
                    }
                }
            }
            return null
        }

        val targetView = findViewWithId(viewGroup)
        if (targetView != null) {
            try {
                // 尝试直接移除父布局
                val parent = targetView.parent as? ViewGroup
                if (parent != null) {
                    val grandParent = parent.parent as? ViewGroup
                    if (grandParent != null) {
                        grandParent.removeView(parent)
                        XposedBridge.log("Removed health headlines cover's parent layout (first attempt)")
                        return
                    }
                }
                
                // 如果上面失败，尝试直接移除目标视图
                val directParent = targetView.parent as? ViewGroup
                if (directParent != null) {
                    directParent.removeView(targetView)
                    XposedBridge.log("Removed health headlines cover directly")
                }
            } catch (e: Exception) {
                XposedBridge.log("Error removing health headlines cover: ${e.message}")
            }
        }
    }

    // 移除所有的营销区域
    @SuppressLint("DiscouragedApi")
    private fun removeAllMarketingAreas(viewGroup: ViewGroup) {
        val marketingAreaId = viewGroup.resources.getIdentifier("marketing_area", "id", viewGroup.context.packageName)
        
        fun findAndRemoveMarketingAreas(parent: ViewGroup) {
            // 从后向前遍历，这样删除时不会影响索引
            for (i in (parent.childCount - 1) downTo 0) {
                val child = parent.getChildAt(i)
                
                // 如果找到marketing_area，移除它
                if (child.id == marketingAreaId) {
                    parent.removeView(child)
                    XposedBridge.log("Removed a marketing_area")
                }
                
                // 递归检查子ViewGroup
                if (child is ViewGroup) {
                    findAndRemoveMarketingAreas(child)
                }
            }
        }

        try {
            findAndRemoveMarketingAreas(viewGroup)
        } catch (e: Exception) {
            XposedBridge.log("Error removing marketing areas: ${e.message}")
        }
    }

    // 移除所有的gone_layout
    @SuppressLint("DiscouragedApi")
    private fun removeAllGoneLayouts(viewGroup: ViewGroup) {
        val goneLayoutId = viewGroup.resources.getIdentifier("gone_layout", "id", viewGroup.context.packageName)
        
        fun findAndRemoveGoneLayouts(parent: ViewGroup) {
            // 从后向前遍历，这样删除时不会影响索引
            for (i in (parent.childCount - 1) downTo 0) {
                val child = parent.getChildAt(i)
                
                // 如果找到gone_layout，移除它
                if (child.id == goneLayoutId) {
                    parent.removeView(child)
                    XposedBridge.log("Removed a gone_layout")
                }
                
                // 递归检查子ViewGroup
                if (child is ViewGroup) {
                    findAndRemoveGoneLayouts(child)
                }
            }
        }

        try {
            findAndRemoveGoneLayouts(viewGroup)
        } catch (e: Exception) {
            XposedBridge.log("Error removing gone layouts: ${e.message}")
        }
    }

    // 移除所有的消息计数
    @SuppressLint("DiscouragedApi")
    private fun removeAllMessageCountNew(viewGroup: ViewGroup) {
        val messageCountId = viewGroup.resources.getIdentifier("txt_message_count_new", "id", viewGroup.context.packageName)
        
        fun findAndRemoveMessageCount(parent: ViewGroup) {
            // 从后向前遍历，这样删除时不会影响索引
            for (i in (parent.childCount - 1) downTo 0) {
                val child = parent.getChildAt(i)
                
                // 如果找到txt_message_count_new，移除它
                if (child.id == messageCountId) {
                    parent.removeView(child)
                    XposedBridge.log("Removed a message count indicator")
                }
                
                // 递归检查子ViewGroup
                if (child is ViewGroup) {
                    findAndRemoveMessageCount(child)
                }
            }
        }

        try {
            findAndRemoveMessageCount(viewGroup)
        } catch (e: Exception) {
            XposedBridge.log("Error removing message count indicators: ${e.message}")
        }
    }

    // 移除运动页面的横幅轮播图
    @SuppressLint("DiscouragedApi")
    private fun removeSportBanner(viewGroup: ViewGroup) {
        val sportBannerId = viewGroup.resources.getIdentifier(
            "view_pager_sport_banner_cant_loop", 
            "id", 
            viewGroup.context.packageName
        )
        
        fun findAndRemoveSportBanner(parent: ViewGroup) {
            // 从后向前遍历，这样删除时不会影响索引
            for (i in (parent.childCount - 1) downTo 0) {
                val child = parent.getChildAt(i)
                
                // 如果找到轮播图，移除它
                if (child.id == sportBannerId) {
                    try {
                        // 尝试移除父布局，因为轮播图通常会有一个容器
                        val grandParent = parent.parent as? ViewGroup
                        if (grandParent != null) {
                            grandParent.removeView(parent)
                            XposedBridge.log("Removed sport banner with parent container")
                        } else {
                            // 如果没有父布局，直接移除轮播图
                            parent.removeView(child)
                            XposedBridge.log("Removed sport banner directly")
                        }
                    } catch (e: Exception) {
                        // 如果移除父布局失败，尝试直接移除轮播图
                        parent.removeView(child)
                        XposedBridge.log("Removed sport banner after parent removal failed")
                    }
                }
                
                // 递归检查子ViewGroup
                if (child is ViewGroup) {
                    findAndRemoveSportBanner(child)
                }
            }
        }

        try {
            findAndRemoveSportBanner(viewGroup)
        } catch (e: Exception) {
            XposedBridge.log("Error removing sport banner: ${e.message}")
        }
    }

    // 移除系列课程布局
    @SuppressLint("DiscouragedApi")
    private fun removeSeriesCourseLayout(viewGroup: ViewGroup) {
        val seriesCourseId = viewGroup.resources.getIdentifier(
            "series_course_layout",
            "id",
            viewGroup.context.packageName
        )
        
        fun findAndRemoveSeriesCourse(parent: ViewGroup) {
            // 从后向前遍历，这样删除时不会影响索引
            for (i in (parent.childCount - 1) downTo 0) {
                val child = parent.getChildAt(i)
                
                // 如果找到系列课程布局，移除它
                if (child.id == seriesCourseId) {
                    try {
                        // 尝试移除父布局
                        val grandParent = parent.parent as? ViewGroup
                        if (grandParent != null) {
                            grandParent.removeView(parent)
                            XposedBridge.log("Removed series course layout with parent container")
                        } else {
                            // 如果没有父布局，直接移除
                            parent.removeView(child)
                            XposedBridge.log("Removed series course layout directly")
                        }
                    } catch (e: Exception) {
                        // 如果移除父布局失败，尝试直接移除
                        parent.removeView(child)
                        XposedBridge.log("Removed series course layout after parent removal failed")
                    }
                }
                
                // 递归检查子ViewGroup
                if (child is ViewGroup) {
                    findAndRemoveSeriesCourse(child)
                }
            }
        }

        try {
            findAndRemoveSeriesCourse(viewGroup)
        } catch (e: Exception) {
            XposedBridge.log("Error removing series course layout: ${e.message}")
        }
    }

    // 移除日常动态布局
    @SuppressLint("DiscouragedApi")
    private fun removeDailyMomentLayout(viewGroup: ViewGroup) {
        val dailyMomentId = viewGroup.resources.getIdentifier(
            "daily_moment_root_layout",
            "id",
            viewGroup.context.packageName
        )
        
        fun findAndRemoveDailyMoment(parent: ViewGroup) {
            // 从后向前遍历，这样删除时不会影响索引
            for (i in (parent.childCount - 1) downTo 0) {
                val child = parent.getChildAt(i)
                
                // 如果找到日常动态布局，移除它
                if (child.id == dailyMomentId) {
                    try {
                        // 尝试移除父布局
                        val grandParent = parent.parent as? ViewGroup
                        if (grandParent != null) {
                            grandParent.removeView(parent)
                            XposedBridge.log("Removed daily moment layout with parent container")
                        } else {
                            // 如果没有父布局，直接移除
                            parent.removeView(child)
                            XposedBridge.log("Removed daily moment layout directly")
                        }
                    } catch (e: Exception) {
                        // 如果移除父布局失败，尝试直接移除
                        parent.removeView(child)
                        XposedBridge.log("Removed daily moment layout after parent removal failed")
                    }
                }
                
                // 递归检查子ViewGroup
                if (child is ViewGroup) {
                    findAndRemoveDailyMoment(child)
                }
            }
        }

        try {
            findAndRemoveDailyMoment(viewGroup)
        } catch (e: Exception) {
            XposedBridge.log("Error removing daily moment layout: ${e.message}")
        }
    }
}
