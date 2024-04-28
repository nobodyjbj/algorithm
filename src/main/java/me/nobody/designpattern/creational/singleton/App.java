package me.nobody.designpattern.creational.singleton;

public class App {

    public static void main(String[] args) {
        ThreadUnsafeObject threadUnsafeSettings1 = ThreadUnsafeObject.getInstanceNotThreadSafety();
        ThreadUnsafeObject threadUnsafeSettings2 = ThreadUnsafeObject.getInstanceNotThreadSafety();
        System.out.println(threadUnsafeSettings1 == threadUnsafeSettings2);

        SyncronizedObject syncronizedSettings1 = SyncronizedObject.getInstanceSynchronized();
        SyncronizedObject syncronizedSettings2 = SyncronizedObject.getInstanceSynchronized();
        System.out.println(syncronizedSettings1 == syncronizedSettings2);

        EagerInitializationObject eagerInitializationSettings1 = EagerInitializationObject.getInstanceNotThreadSafety();
        EagerInitializationObject eagerInitializationSettings2 = EagerInitializationObject.getInstanceNotThreadSafety();
        System.out.println(eagerInitializationSettings1 == eagerInitializationSettings2);

        DoubleCheckLockingObject doubleCheckLockingObject1 = DoubleCheckLockingObject.getInstanceNotThreadSafety();
        DoubleCheckLockingObject doubleCheckLockingObject2 = DoubleCheckLockingObject.getInstanceNotThreadSafety();
        System.out.println(doubleCheckLockingObject1 == doubleCheckLockingObject2);

        StaticInnerClassObject staticInnerClassObject1 = StaticInnerClassObject.getInstanceNotThreadSafety();
        StaticInnerClassObject staticInnerClassObject2 = StaticInnerClassObject.getInstanceNotThreadSafety();
        System.out.println(staticInnerClassObject1 == staticInnerClassObject2);

        EnumObject enumObject1 = EnumObject.INSTANCE;
        EnumObject enumObject2 = EnumObject.INSTANCE;
        System.out.println(enumObject1 == enumObject2);
    }
}
