package com.lwq.springboot01.service.transactionalTest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lwq.springboot01.dao.schoolRepository.PersonRepository;
import com.lwq.springboot01.entity.schoolstory.Person;

import lombok.extern.slf4j.Slf4j;

/**
 * 用于事务测试 多层调用,防止同类方法调用事务失效
 */
@Slf4j
@Service
public class TransactionalTestService2 {
    @Autowired
    private PersonRepository pr;

    @Transactional
    public void add1() {
        Person p1 = Person.builder().name("zhangfei").age(55).birthday(LocalDateTime.now()).build();
        pr.save(p1);
    }

    /**
     * REQUIRED：如果当前没有事务，就新建一个事务；如果已经存在一个事务中，就加入到这个事务中。
     * SUPPORTS：如果当前有事务，则加入这个事务；如果没有事务，则不使用事务。
     * MANDATORY：如果当前有事务，则加入这个事务；如果没有事务，则抛出异常。
     * REQUIRES_NEW：新建一个事务，如果当前存在事务，则挂起当前事务。
     * NOT_SUPPORTED：不使用事务，如果当前存在事务，则挂起当前事务。
     * NEVER：不使用事务，如果当前存在事务，则抛出异常。
     * NESTED：如果当前存在事务，则在嵌套事务中执行；如果当前没有事务，则新建一个事务,外部事务回滚时，NESTED事务也会被回滚,NESTED回滚,外部事务不回滚?不确定。
     * 
     * 
     * REQUIRES_NEW 和 NESTED区别:
     * 
     * REQUIRES_NEW 传播行为：
     * 本质：REQUIRES_NEW 意味着每次调用该方法时，都会启动一个全新的事务，即使已经存在一个事务。
     * 独立性：新事务与调用者的事务完全独立，并且有自己的隔离级别、超时时间等属性。
     * 状态：调用者的事务会被挂起，直到新事务完成。
     * 效果：可以保证方法中的操作在一个干净、独立的事务环境中执行，不受调用者事务的影响。
     * 
     * ESTED 传播行为：
     * 本质：NESTED 表示如果当前存在事务，该方法将在嵌套事务中执行。如果不存在事务，则创建一个新事务。
     * 嵌套性：嵌套事务是外部事务的子事务，它们共享相同的事务边界（如隔离级别、超时时间）。
     * 回滚影响：如果嵌套事务回滚，它将影响整个事务，包括外部事务。
     * 状态：在嵌套事务执行期间，调用者的事务是活跃的，它可以看到嵌套事务中所做的更改。
     * 
     * 相似点：
     * 新事务创建：两者都会在没有事务上下文的情况下创建新的事务。
     * 数据隔离：它们都提供了一定程度的数据隔离，确保方法内的操作不会干扰其他事务。
     * 不同点：
     * 传播行为：REQUIRES_NEW 每次都会创建一个全新的事务，而 NESTED 则会在已存在的事务内部创建一个子事务。
     * 事务独立性：REQUIRES_NEW 启动的事务完全独立，而 NESTED 中的子事务依赖于外部事务。
     * 回滚影响：REQUIRES_NEW 中的事务回滚不会影响外部事务，而 NESTED 中的子事务回滚会影响外部事务。
     * 可见性：REQUIRES_NEW 中的操作在外部事务中不可见，而 NESTED 中的操作在外部事务中可见。
     * 
     * 在实际应用中，选择哪种传播行为取决于具体需求。
     * REQUIRES_NEW 适合需要强隔离性和独立性的操作，例如执行一些关键的业务逻辑，确保数据的完整性和准确性。
     * NESTED则适合于需要与调用者事务协同工作，并且可以在必要时回滚整个事务的操作。
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void add1REQUIRES_NEW() {
        Person p1 = Person.builder().name("zhangfei").age(55).birthday(LocalDateTime.now()).build();
        pr.save(p1);
    }

    @Transactional(propagation = Propagation.NESTED)
    public void add1NESTED() {
        Person p1 = Person.builder().name("zhangfei").age(55).birthday(LocalDateTime.now()).build();
        pr.save(p1);
    }

    @Transactional(propagation = Propagation.NESTED)
    public void add1NESTEDexception() {
        Person p1 = Person.builder().name("zhangfei").age(55).birthday(LocalDateTime.now()).build();
        pr.save(p1);
        throw new RuntimeException();

    }

}
