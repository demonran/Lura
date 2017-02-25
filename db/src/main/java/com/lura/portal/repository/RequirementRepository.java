package com.lura.portal.repository;

import com.lura.portal.model.db.DRequirement;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by liuran on 2017/2/25.
 */
public interface RequirementRepository  extends CrudRepository<DRequirement,Long> {

}
