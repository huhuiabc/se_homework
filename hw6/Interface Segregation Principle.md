# 接口隔离原则———Interface Segregation Principle

## 一、SOLID原则
>在软件设计、编码过程中有几个基本原则即SOLID原则，学习理解能够帮忙我们写出更健壮的代码。SOLID是五个基本原则的首字母。这五个原则如下：Single responsibility、Open closed、Liskov substitution、Interface segregation、Dependency inversion，在此我将具体对Interface Segregation Principle即接口隔离原则进行详细介绍。

## 二、接口隔离原则简介
- 接口隔离原则：Clients should not be forced to depend upon interfaces that they don’t use。即：客户不应该被迫依赖于他们不使用的接口。
- 接口隔离原则规定客户端不应该被迫实现他们不使用的接口。 相比一个大的接口，许多小的接口要更好，它要求将一个个子模块拆分开，在某种程度上，其和单一职责原则有些类似，都有强调到按照清晰的职责来拆分。

## 三、接口隔离原则具体要求及代码示例
- 接口隔离原则要求为各个类建立它们需要的专用接口，而不要试图去建立一个很庞大的接口供所有依赖它的类去调用，强调要提供足够小的接口。
- 使用者依赖了那些它们不使用的方法，就面临着这些未使用的方法改变而带来的变更，无意中导致了它们之间的耦合。

- 例子：学生成绩管理系统包含三个模块：输入成绩模块（插入成绩、删除成绩、修改成绩）；统计成绩模块（计算总分、计算平均分）；打印成绩模块（打印成绩信息、査询成绩信息）。
- 相关代码如下：
```java
/**
 * 输入模块接口
 */
public interface InputModule {
    void insert();
    
    void delete();
    
    void modify();
}
/**
 * 统计模块接口
 */
public interface CountModule {
    void countTotalScore();
    
    void countAverage();
}
/**
 * 打印模块接口
 */
public interface PrintModule {
    void printStuInfo();
    
    void queryStuInfo();
}
/**
 * 实现类
 */
public class StuScoreList implements InputModule, CountModule, PrintModule {
    private StuScoreList() {
    }
    public static InputModule getInputModule() {
    return (InputModule) new StuScoreList();
    }
    public static CountModule getCountModule() {
    return (CountModule) new StuScoreList();
    }
    public static PrintModule getPrintModule() {
    return (PrintModule) new StuScoreList();
    }
    public void insert() {
        System.out.println("删除成绩");
    }
    public void delete() {
        System.out.println("删除成绩");
    }
    public void modify() {
        System.out.println("修改成绩");
    }
    public void countTotalScore() {
        System.out.println("计算总分");
    }
    public void countAverage() {
        System.out.println("计算平均分");
    }
    public void printStuInfo() {
        System.out.println("打印成绩信息");
    }
    public void queryStuInfo() {
        System.out.println("査询成绩信息");
    }
}
```
## 四、总结

- 接口隔离原则要求我们：
1. 接口应该尽量小，但是要有限度
2. 接口只暴露给依赖接口的类（调用端）需要的方法，而不需要暴露不需要的方法；
3. 提高模块的内聚，减少它们之间的耦合。

- 像其他的原则一样，接口隔离原则也是需要在设计、重构过程中需要话费时间来思考如何运用。有时候因为时间紧迫我们可能着急于完成功能，但是当我们不断的进行扩展，添加新功能的时候，会发现，如果不重构，这段代码将越来越难重构，以至于拖累项目运转。

- 可能有人会觉的接口隔离原则与单一职责原则很类似，其实不然。其一，单一职责原则原注重的是职责；而接口隔离原则注重对接口依赖的隔离。其二，单一职责原则主要是约束类，其次才是接口和方法，它针对的是程序中的实现和细节,而接口隔离原则主要约束接口，主要针对抽象，针对程序整体框架的构建。