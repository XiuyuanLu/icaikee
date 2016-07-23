package com.icaikee.wrap.biz;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AddressConfig {

	@Value("#{configProperties['imgrepo.address.save']}")
	private String saveAddress;

	@Value("#{configProperties['imgrepo.address.read']}")
	private String readAddress;

	@Value("#{configProperties['imgrepo.index.address.save']}")
	private String indexSaveAddress;

	@Value("#{configProperties['imgrepo.index.address.read']}")
	private String indexReadAddress;

	@Value("#{configProperties['imgrepo.software.instruction.address']}")
	private String softwareInstructionAddress;

	public String getSaveAddress() {
		return saveAddress;
	}

	public void setSaveAddress(String saveAddress) {
		this.saveAddress = saveAddress;
	}

	public String getReadAddress() {
		return readAddress;
	}

	public void setReadAddress(String readAddress) {
		this.readAddress = readAddress;
	}

	public String getIndexSaveAddress() {
		return indexSaveAddress;
	}

	public void setIndexSaveAddress(String indexSaveAddress) {
		this.indexSaveAddress = indexSaveAddress;
	}

	public String getIndexReadAddress() {
		return indexReadAddress;
	}

	public void setIndexReadAddress(String indexReadAddress) {
		this.indexReadAddress = indexReadAddress;
	}

	public String getSoftwareInstructionAddress() {
		return softwareInstructionAddress;
	}

	public void setSoftwareInstructionAddress(String softwareInstructionAddress) {
		this.softwareInstructionAddress = softwareInstructionAddress;
	}

}
