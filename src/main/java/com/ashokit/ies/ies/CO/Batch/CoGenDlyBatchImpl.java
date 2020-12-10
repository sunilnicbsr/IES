package com.ashokit.ies.ies.CO.Batch;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.ies.ies.CO.Entity.COTriggersEntity;
import com.ashokit.ies.ies.CO.Entity.CoBatchDtlsEntity;
import com.ashokit.ies.ies.CO.Repository.COTriggersRepository;
import com.ashokit.ies.ies.CO.Repository.CObatchRepository;
import com.ashokit.ies.ies.ED.Repository.EDRepository;

@Service
public class CoGenDlyBatchImpl implements CoGenDlyBatch {

	@Autowired
	EDRepository edRepo;

	@Autowired
	COTriggersRepository coTrgrRepo;

	@Autowired
	CObatchRepository coBatchRepo;

	@Override
	public boolean preProcess() {
		// TODO send flag as true or false
		CoBatchDtlsEntity coBatchEntity = new CoBatchDtlsEntity();

		coBatchEntity.setBatchName("CO_BATCH");
		coBatchEntity.setStartDate(new Date());
		coBatchEntity.setBatchRunStatus("BATCH_STARTED");

		coBatchRepo.save(coBatchEntity);

		return false;
	}

	@Override
	public boolean postProcess() {
		// TODO send flag as true or false

		CoBatchDtlsEntity coBatchEntity = new CoBatchDtlsEntity();

		coBatchEntity.setBatchName("CO_BATCH");
		coBatchEntity.setEndDate(new Date());
		coBatchEntity.setBatchRunStatus("BATCH_END");

		coBatchRepo.save(coBatchEntity);

		return false;
	}

	@Override
	public boolean process() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean start() {
		List<COTriggersEntity> findByStatus = coTrgrRepo.findByTrgStatus("P");// P for Pending
		if ((findByStatus != null) && !findByStatus.isEmpty()) {
			for (COTriggersEntity element : findByStatus) {
				preProcess();
			}

		}
		return false;
	}

}
