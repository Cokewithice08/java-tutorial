## 反射API
- 获取类名
- 获取类修饰符
- 获取类包信息
- 获取类的父类
- 获取类实现接口
- 获取类构造方法
- 获取类字段
- 获取类方法
### 获取类名
- 获取类名 `clazz.getSimpleName()`
- 获取带包名的类名 `clazz.getName()`
- 获取准确的名称 `clazz.getCanonicalName()`

[获取类名的示例](https://github.com/jast90/java-tutorial/blob/master/java-reflection/src/main/java/cn/jast/java/reflection/ClassNames.java)

### 获取类修饰符
获取类限定符
1. public/protected/private
2. abstract
3. final
4. static
5. native
6. interface
7. synchronized
8. transient
9. volatile

[获取类修饰符示例](https://github.com/jast90/java-tutorial/blob/master/java-reflection/src/main/java/cn/jast/java/reflection/ClassModifiers.java)

### 获取类包信息

`stringClass.getPackage()`

[获取类包信息示例](https://github.com/jast90/java-tutorial/blob/master/java-reflection/src/main/java/cn/jast/java/reflection/ClassPackage.java)

### 获取类的父类

` stringClass.getSuperclass()`

[获取类的父类示例](https://github.com/jast90/java-tutorial/blob/master/java-reflection/src/main/java/cn/jast/java/reflection/SuperClass.java)

### 获取实现接口
`stringClass.getInterfaces()`

[获取实现接口示例示例](https://github.com/jast90/java-tutorial/blob/master/java-reflection/src/main/java/cn/jast/java/reflection/ImplementedInterfaces.java)

### 获取类构造方法
- `integerClass.getConstructors()`
- `integerClass.getConstructor(int.class)`
- `(Integer) constructor.newInstance(1);`

[获取类构造方法示例示例](https://github.com/jast90/java-tutorial/blob/master/java-reflection/src/main/java/cn/jast/java/reflection/ClassConstructors.java)
### 获取类字段
- `integerClass.getDeclaredFields()`
- `field.isAccessible()`
- `field.setAccessible(true);`
- `field.set(myClass1,1);`

[获取类字段示例](https://github.com/jast90/java-tutorial/blob/master/java-reflection/src/main/java/cn/jast/java/reflection/ClassFields.java)
### 获取类方法
- `myclass.getMethods()`：获取本类或父类所有可见方法名称
- `myclass.getDeclaredMethods()`：获取本类的所有方法名称
- `method.invoke(myClass,1);`

[获取类方法示例](https://github.com/jast90/java-tutorial/blob/master/java-reflection/src/main/java/cn/jast/java/reflection/ClassMethods.java)

## 参考
- https://www.baeldung.com/java-reflection

