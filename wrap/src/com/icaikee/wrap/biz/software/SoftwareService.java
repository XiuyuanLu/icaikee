package com.icaikee.wrap.biz.software;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.icaikee.wrap.biz.AddressConfig;
import com.icaikee.wrap.biz.software.model.Software;
import com.icaikee.wrap.db.hibernate.HibernateDao;

@Service
public class SoftwareService {

	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private HibernateDao dao;

	@Autowired
	private AddressConfig addressConfig;

	public void uploadInstruction(MultipartFile instruction) {
		try {
			if (ImageIO.read(instruction.getInputStream()) == null) {
				logger.info("not img");
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		String saveAddr = addressConfig.getSoftwareSaveAddress();
		String fileName = "software-instruction.jpg";

		String filePath = saveAddr + fileName;

		try {
			instruction.transferTo(new File(filePath));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void uploadSoftware(MultipartFile software) {

		String saveAddr = addressConfig.getSoftwareSaveAddress();
		String fileName = "software.zip";

		String filePath = saveAddr + fileName;

		try {
			software.transferTo(new File(filePath));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Transactional
	public void updateAccessTime(int count) {
		Software x = dao.findUnique(Software.class, "select x from Software x where x.id=1");
		if (x == null)
			return;
		x.setDownloadTime(count);
		dao.save(x);
	}

	public Integer getSoftwareDownloadTime() {
		return dao.findUnique(Integer.class, "select x.downloadTime from Software x where x.id=1");
	}

}
