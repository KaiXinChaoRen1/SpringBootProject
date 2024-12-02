package com.lwq.jk2_JPA.multiTenancy;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.stereotype.Component;

@Component
public class CustomPhysicalNamingStrategy implements PhysicalNamingStrategy {

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        System.out.println("toPhysicalTableName执行啦");
        String tenantId = TenantContext.getCurrentTenant();
        if (tenantId == null || tenantId.isEmpty()) {
            System.out.println("租户ID为空！");
            return Identifier.toIdentifier(name.getText() + "_default");
        }
        String newTableName = name.getText() + "_" + tenantId; // 在表名后添加租户ID
        return Identifier.toIdentifier(newTableName);
    }

    // 其他方法保持默认实现
    @Override
    public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment context) {
        return name;
    }

    @Override
    public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment context) {
        return name;
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment context) {
        return name;
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
        return name;
    }
}
