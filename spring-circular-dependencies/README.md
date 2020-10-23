## Spring 循环依赖注入
- Spring bean 循环依赖是通过构造方法注入时，Spring容器会在启动的时候直接启动失败，报出` Requested bean is currently in creation: Is there an unresolvable circular reference?`，对于构造方法注入的循环依赖Spring容器无法自动解决。只能编码人员将循环依赖的bean改为setter或属性注入的方式解决。
- Spring bean 循环依赖是通过属性和setter注入时，Spring容器会自动处理循环依赖，spring 容器可以正常启动。

### 构造方法依赖注入
启动报错，需要人为改为属性或setter注入。为什么构造方法注入无法解决呢？因为构造方法都是通过new来创建实例的，而出现循环依赖时会出现互相等待实例化，从而产生死等待。

### 属性或setter注入
为什么属性和setter注入可以解决循环依赖呢？因为不需要死等待，都能实例化。