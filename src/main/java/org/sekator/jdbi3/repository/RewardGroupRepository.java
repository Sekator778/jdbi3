package org.sekator.jdbi3.repository;

import org.jdbi.v3.spring5.JdbiRepository;
import org.jdbi.v3.sqlobject.config.RegisterConstructorMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.sekator.jdbi3.dto.RewardGroup;

import java.util.List;

/**
 * @author dn070578noi
 * @created 23 кві, 2024
 */
@JdbiRepository
public interface RewardGroupRepository {
    @SqlQuery("SELECT * FROM reward_group")
    @RegisterConstructorMapper(RewardGroup.class)
    List<RewardGroup> getAll();
}
