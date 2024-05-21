package com.kh.journey.accommodation.vo;

public class AccommodationVo {
   private String no;
   private String hostNo;
   private String name;
   private String address;
   private String imgUrl;
   private String enrollDate;
   private String modifyDate;
   private String delYn;
   private String exposeYn;
   private String latitude;
   private String longitude;
   private String swimYn;
   private String spaYn;
   private String disabledYn;
   private String parkingYn;
   private String elevatorYn;
   private String breakfastYn;
   private String smokeYn;
   
   private String hostName;
   private String hostPhone;
   
   // Constructor
   public AccommodationVo(String no, String hostNo, String name, String address, String imgUrl, String enrollDate,
         String modifyDate, String delYn, String exposeYn, String latitude, String longitude, String swimYn,
         String spaYn, String disabledYn, String parkingYn, String elevatorYn, String breakfastYn, String smokeYn,
         String hostName, String hostPhone) {
      this.no = no;
      this.hostNo = hostNo;
      this.name = name;
      this.address = address;
      this.imgUrl = imgUrl;
      this.enrollDate = enrollDate;
      this.modifyDate = modifyDate;
      this.delYn = delYn;
      this.exposeYn = exposeYn;
      this.latitude = latitude;
      this.longitude = longitude;
      this.swimYn = swimYn;
      this.spaYn = spaYn;
      this.disabledYn = disabledYn;
      this.parkingYn = parkingYn;
      this.elevatorYn = elevatorYn;
      this.breakfastYn = breakfastYn;
      this.smokeYn = smokeYn;
      this.hostName = hostName;
      this.hostPhone = hostPhone;
   }
   public AccommodationVo() {
   }
   
   @Override
   public String toString() {
      return "AccommodationVo [no=" + no + ", hostNo=" + hostNo + ", name=" + name + ", address=" + address
            + ", imgUrl=" + imgUrl + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", delYn="
            + delYn + ", exposeYn=" + exposeYn + ", latitude=" + latitude + ", longitude=" + longitude + ", swimYn="
            + swimYn + ", spaYn=" + spaYn + ", disabledYn=" + disabledYn + ", parkingYn=" + parkingYn
            + ", elevatorYn=" + elevatorYn + ", breakfastYn=" + breakfastYn + ", smokeYn=" + smokeYn + ", hostName="
            + hostName + ", hostPhone=" + hostPhone + "]";
   }
   
   // Getter, Setter
   public String getNo() {
      return no;
   }
   public void setNo(String no) {
      this.no = no;
   }
   public String getHostNo() {
      return hostNo;
   }
   public void setHostNo(String hostNo) {
      this.hostNo = hostNo;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getAddress() {
      return address;
   }
   public void setAddress(String address) {
      this.address = address;
   }
   public String getImgUrl() {
      return imgUrl;
   }
   public void setImgUrl(String imgUrl) {
      this.imgUrl = imgUrl;
   }
   public String getEnrollDate() {
      return enrollDate;
   }
   public void setEnrollDate(String enrollDate) {
      this.enrollDate = enrollDate;
   }
   public String getModifyDate() {
      return modifyDate;
   }
   public void setModifyDate(String modifyDate) {
      this.modifyDate = modifyDate;
   }
   public String getDelYn() {
      return delYn;
   }
   public void setDelYn(String delYn) {
      this.delYn = delYn;
   }
   public String getExposeYn() {
      return exposeYn;
   }
   public void setExposeYn(String exposeYn) {
      this.exposeYn = exposeYn;
   }
   public String getLatitude() {
      return latitude;
   }
   public void setLatitude(String latitude) {
      this.latitude = latitude;
   }
   public String getLongitude() {
      return longitude;
   }
   public void setLongitude(String longitude) {
      this.longitude = longitude;
   }
   public String getSwimYn() {
      return swimYn;
   }
   public void setSwimYn(String swimYn) {
      this.swimYn = swimYn;
   }
   public String getSpaYn() {
      return spaYn;
   }
   public void setSpaYn(String spaYn) {
      this.spaYn = spaYn;
   }
   public String getDisabledYn() {
      return disabledYn;
   }
   public void setDisabledYn(String disabledYn) {
      this.disabledYn = disabledYn;
   }
   public String getParkingYn() {
      return parkingYn;
   }
   public void setParkingYn(String parkingYn) {
      this.parkingYn = parkingYn;
   }
   public String getElevatorYn() {
      return elevatorYn;
   }
   public void setElevatorYn(String elevatorYn) {
      this.elevatorYn = elevatorYn;
   }
   public String getBreakfastYn() {
      return breakfastYn;
   }
   public void setBreakfastYn(String breakfastYn) {
      this.breakfastYn = breakfastYn;
   }
   public String getSmokeYn() {
      return smokeYn;
   }
   public void setSmokeYn(String smokeYn) {
      this.smokeYn = smokeYn;
   }
   public String getHostName() {
      return hostName;
   }
   public void setHostName(String hostName) {
      this.hostName = hostName;
   }
   public String getHostPhone() {
      return hostPhone;
   }
   public void setHostPhone(String hostPhone) {
      this.hostPhone = hostPhone;
   }
}