package ltd.nextalone.wifinocacert.sdk30

import de.robv.android.xposed.XposedHelpers
import ltd.nextalone.wifinocacert.HookEntry
import ltd.nextalone.wifinocacert.utils.clazz
import ltd.nextalone.wifinocacert.utils.logDetail
import ltd.nextalone.wifinocacert.utils.logStart
import ltd.nextalone.wifinocacert.utils.method


object SettingWifiConfigControllerHook {

    fun initOnce() {
        logStart()
        val clz = "com.android.settings.wifi.WifiConfigController".clazz
        clz?.javaClass?.let { logDetail("clz", it) }
        XposedHelpers.findAndHookConstructor(clz, HookEntry.lpClassLoader)
        val isSubmittable = clz?.method("isSubmittable")
        isSubmittable?.name?.let { logDetail("method", it) }
//        isSubmittable?.replace(true)
    }
}

