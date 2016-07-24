package com.icaikee.wrap.biz.software;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.icaikee.wrap.biz.AddressConfig;

@Service
public class SoftwareService {

	Logger logger = Logger.getLogger(this.getClass());

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

}
