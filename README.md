# bcr_test_application
Android application for testing of BOOT_COMPLETED receiver behavior when preinstalled app is updated not via OTA

The Android system has a limitation to receive the BOOT_COMPLETED system's event for third party applications. such a receiver will not receive intents until the application is launched for the first time (by the User or by explicit intent).
The purpose of this project is to check whether this receiver will work if the application is preinstalled in the system (added into AOSP build) and BOOT_COMPLETED receiver is added in the application updated.

First commit: version for AOSP build
Second commit: updated version with BOOT_COMPLETED receiver added

Result: the receiver is activated after the the update without starting by the User.
