#include <jni.h>
#include "migrationmodule.h"
#include "log.h"

extern "C" JNIEXPORT jdouble JNICALL
Java_com_MigrationModule_MigrationModuleModule_nativeMultiply(JNIEnv *env, jclass type, jdouble num1, jdouble num2)
{
    LOGI("Calling nativeMultiply");
    return migrationmodule::multiply(num1, num2);
}