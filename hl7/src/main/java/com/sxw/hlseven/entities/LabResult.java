package com.sxw.hlseven.entities;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.sxw.hlseven.validation.groups.ValidationJsonEntityGroup;
import com.sxw.hlseven.validation.validators.StringNotNullEmpty;

/**
 * 
 * @author Stephen.Zhang@covisint.com
 * 
 */
public class LabResult {

    private String recordId;
    @Length(max = 50, min = 1, message = "1002", groups = ValidationJsonEntityGroup.class)
    @StringNotNullEmpty(errorCode = "1001")
    private String patientId;

    @StringNotNullEmpty(errorCode = "1003")
    private String sourceTpId;

    @Length(min = 1, max = 3, message = "1005", groups = ValidationJsonEntityGroup.class)
    @StringNotNullEmpty(errorCode = "1004")
    private String valueType;

    @Length(min = 0, max = 40, message = "Lab Entry Code should be 1 to 40 characters long", groups = ValidationJsonEntityGroup.class)
    @StringNotNullEmpty(errorCode = "Lab Entry Code")
    private String labEntryCode;

    @Length(min = 0, max = 56, message = "Lab Entry Label should be 1 to 56 characters long", groups = ValidationJsonEntityGroup.class)
    private String labEntryLabel;

    @Length(min = 0, max = 20, message = "Sub Code max length is 20", groups = ValidationJsonEntityGroup.class)
    private String subCode;

    @Length(min = 1, max = 1000, message = "Value should be 1 to 1000 characters long", groups = ValidationJsonEntityGroup.class)
    @StringNotNullEmpty(errorCode = "Value")
    private String value;

    @Length(min = 0, max = 705, message = "Units should be 0 to  705 characters long", groups = ValidationJsonEntityGroup.class)
    private String units;

    @Length(min = 0, max = 60, message = "Reference Range max length is 60", groups = ValidationJsonEntityGroup.class)
    private String referenceRange;

    @Length(min = 1, max = 5, message = "Abnormal Flag's length cannot exceed 5", groups = ValidationJsonEntityGroup.class)
    @StringNotNullEmpty(errorCode = "Abnormal Flag")
    private String abnormalFlags;

    @Length(min = 1, max = 1, message = "Result status max length is 1", groups = ValidationJsonEntityGroup.class)
    @StringNotNullEmpty(errorCode = "Result status")
    private String resultStatus;

    @Length(max = 24, min = 14, message = "Observation Time should be 14 to 24 characters long", groups = ValidationJsonEntityGroup.class)
    //@DateTimeStamp(errorCode = "Observation Time", value = DateTimeStampFormat.yyyyMMddHHmmssPlus, mandatoryOrOptional = AttributeType.MANDATORY)
    @StringNotNullEmpty(errorCode = "Observation Time")
    private String observationTime;

    private String producerId;
    private List<Observer> observer;

    @Length(min = 0, max = 128, message = "ObservationMethodshould be 0 to 705 characters long", groups = ValidationJsonEntityGroup.class)
    private String observationMethod;

    @Override
    public String toString() {
        return "InsertClinicalLabResults[recordId=" + recordId + ", patientId=" + patientId + ", sourceTpId="
                + sourceTpId + ",valueType=" + valueType + ", labEntryCode=" + labEntryCode + ", labEntryLabel="
                + labEntryLabel + ", subCode=" + subCode + ", value=" + value + ", units" + units + ", referenceRange="
                + referenceRange + ",abnormalFlags=" + abnormalFlags + ", resultStatus=" + resultStatus
                + ", observationTime=" + observationTime + ", producerId=" + producerId + ", observationMethod="
                + observationMethod + "]";
    }

    /**
     * @return the recordId
     */
    public String getRecordId() {
        return recordId;
    }

    /**
     * @param recordId
     *            the recordId to set
     */
    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    /**
     * @return the patientId
     */
    public String getPatientId() {
        return patientId;
    }

    /**
     * @param patientId
     *            the patientId to set
     */
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    /**
     * @return the sourceTpId
     */
    public String getSourceTpId() {
        return sourceTpId;
    }

    /**
     * @param sourceTpId
     *            the sourceTpId to set
     */
    public void setSourceTpId(String sourceTpId) {
        this.sourceTpId = sourceTpId;
    }

    /**
     * @return the valueType
     */
    public String getValueType() {
        return valueType;
    }

    /**
     * @param valueType
     *            the valueType to set
     */
    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    /**
     * @return the labEntryCode
     */
    public String getLabEntryCode() {
        return labEntryCode;
    }

    /**
     * @param labEntryCode
     *            the labEntryCode to set
     */
    public void setLabEntryCode(String labEntryCode) {
        this.labEntryCode = labEntryCode;
    }

    /**
     * @return the labEntryLabel
     */
    public String getLabEntryLabel() {
        return labEntryLabel;
    }

    /**
     * @param labEntryLabel
     *            the labEntryLabel to set
     */
    public void setLabEntryLabel(String labEntryLabel) {
        this.labEntryLabel = labEntryLabel;
    }

    /**
     * @return the subCode
     */
    public String getSubCode() {
        return subCode;
    }

    /**
     * @param subCode
     *            the subCode to set
     */
    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     *            the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return the units
     */
    public String getUnits() {
        return units;
    }

    /**
     * @param units
     *            the units to set
     */
    public void setUnits(String units) {
        this.units = units;
    }

    /**
     * @return the referenceRange
     */
    public String getReferenceRange() {
        return referenceRange;
    }

    /**
     * @param referenceRange
     *            the referenceRange to set
     */
    public void setReferenceRange(String referenceRange) {
        this.referenceRange = referenceRange;
    }

    /**
     * @return the abnormalFlags
     */
    public String getAbnormalFlags() {
        return abnormalFlags;
    }

    /**
     * @param abnormalFlags
     *            the abnormalFlags to set
     */
    public void setAbnormalFlags(String abnormalFlags) {
        this.abnormalFlags = abnormalFlags;
    }

    /**
     * @return the resultStatus
     */
    public String getResultStatus() {
        return resultStatus;
    }

    /**
     * @param resultStatus
     *            the resultStatus to set
     */
    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }

    /**
     * @return the observationTime
     */
    public String getObservationTime() {
        return observationTime;
    }

    /**
     * @param observationTime
     *            the observationTime to set
     */
    public void setObservationTime(String observationTime) {
        this.observationTime = observationTime;
    }

    /**
     * @return the producerId
     */
    public String getProducerId() {
        return producerId;
    }

    /**
     * @param producerId
     *            the producerId to set
     */
    public void setProducerId(String producerId) {
        this.producerId = producerId;
    }

    /**
     * @return the observer
     */
    public List<Observer> getObserver() {
        return observer;
    }

    /**
     * @param observer
     *            the observer to set
     */
    public void setObserver(List<Observer> observer) {
        this.observer = observer;
    }

    /**
     * @return the observationMethod
     */
    public String getObservationMethod() {
        return observationMethod;
    }

    /**
     * @param observationMethod
     *            the observationMethod to set
     */
    public void setObservationMethod(String observationMethod) {
        this.observationMethod = observationMethod;
    }

}