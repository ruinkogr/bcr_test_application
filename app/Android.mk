# https://stackoverflow.com/questions/67692706/presigned-apk-loses-signature-in-aosp-build

LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
APK_VERSION := 1.0.0.0
LOCAL_MODULE := BCRTestApp
LOCAL_SRC_FILES := build/outputs/apk/release/app-release.apk
LOCAL_MODULE_TAGS := optional
LOCAL_MODULE_CLASS := APPS
LOCAL_MODULE_SUFFIX := $(COMMON_ANDROID_PACKAGE_SUFFIX)
LOCAL_CERTIFICATE := PRESIGNED
#LOCAL_CERTIFICATE := platform
LOCAL_PRIVILEGED_MODULE := true
LOCAL_SDK_VERSION := 31
#LOCAL_PRIVATE_PLATFORM_APIS := true
#LOCAL_PRODUCT_MODULE := true
#LOCAL_REQUIRED_MODULES := privapp_whitelist_com.android.settings
#LOCAL_USE_AAPT2 := true
include $(BUILD_PREBUILT)