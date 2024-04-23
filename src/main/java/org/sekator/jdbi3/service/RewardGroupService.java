package org.sekator.jdbi3.service;

import lombok.RequiredArgsConstructor;
import org.sekator.jdbi3.dto.RewardGroup;
import org.sekator.jdbi3.repository.RewardGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dn070578noi
 * @created 23 кві, 2024
 */
@Service
@RequiredArgsConstructor
public class RewardGroupService {
    private final RewardGroupRepository rewardGroupRepository;

    public List<RewardGroup> getAll() {
        return rewardGroupRepository.getAll();
    }
}
