Create Table T_BD_Person(FId Varchar(50) not null,FAge Int not null,FName Varchar(100) not null,FNumber Varchar(50) not null,primary key(FId));
Create Table T_BD_Material(FId Varchar(50) not null,FNumber Varchar(50) not null,FName Varchar(50),FSupplierId Varchar(50) not null,FType Varchar(50),FMeasureUnitGroupId Varchar(50) not null,Fdescription Varchar(100),primary key(FId));
Create Table T_BD_Supplier(FId Varchar(50) not null,FNumber Varchar(50) not null,FName Varchar(100) not null,FAddress Varchar(100),FEmail Varchar(50),FPhone Varchar(50),Fdescription Varchar(100),primary key(FId));
Create Table T_BD_Customer(FId Varchar(50) not null,FNumber Varchar(50) not null,FName Varchar(100) not null,FAddress Varchar(100),FEmail Varchar(50),FPhone Varchar(50),Fdescription Varchar(100),primary key(FId));
Create Table T_BD_MeasureUnitGroup(FId Varchar(50) not null,FName Varchar(50) not null,primary key(FId));
Create Table T_BD_MeasureUnit(FId Varchar(50) not null,FNumber Varchar(50) not null,FName Varchar(50) not null,FIsBaseUnit bit not null,FConvertRate Numeric(28,10) not null,Fdescription Varchar(100),FHeadId Varchar(50) not null,primary key(FId));
Create Table T_BS_User(FId Varchar(50) not null,FNumber Varchar(50) not null,FPassword Varchar(50) not null,FPersonId Varchar(50) not null,FIsSuperAdmin bit,FIsFreezed bit not null,primary key(FId));
Create Table T_BS_UserPermItem(FId Varchar(50) not null,FPermName Varchar(50) not null,FHeadId Varchar(50) not null,primary key(FId));
Create Table T_BS_NumberRule(FId Varchar(50),FNumber Varchar(50) not null,FCurSN Varchar(50),FNumberRule Varchar(500) not null,FUseSN bit not null,FSNLength Int not null,primary key(FId));
Create Table T_BS_LogItem(FId Varchar(50) not null,FDate DateTime not null,FUserId Varchar(50) not null,FOprtName Varchar(100) not null,FDESCription Varchar(500) ,primary key(FId));
Create Table T_BS_FilterSolution(FId Varchar(50) not null,FName Varchar(50) not null,FSortRule Varchar(500),FSolutionId Varchar(100) not null,FParams Varchar(500),primary key(FId));
Create Table T_INV_InInventoryBill(FId Varchar(50) not null,FNumber Varchar(50) not null,FCreateDate DateTime not null,FInDate DateTime not null,FAccountDate DateTime,FOperatorId Varchar(50) not null,FIsRedBill bit not null,FBillState Varchar(10) not null,FDescription Varchar(100),primary key(FId));
Create Table T_INV_InInvBillDetail(FId Varchar(50) not null,FHeadId Varchar(50) not null,FMaterialId Varchar(50) not null,FMeasureUnitId Varchar(50) not null,FQty Numeric(28,10) not null,FBaseQty Numeric(28,10) not null,FBasePrice Numeric(28,10) not null,FAmount Numeric(28,10) not null,primary key(FId));
Create Table T_INV_InvAccount(FId Varchar(50) not null,FMaterialId Varchar(50) not null,FMaterialNumber Varchar(50) not null,FMaterialName Varchar(50) not null,FBillId Varchar(50),FBillNumber Varchar(50),FAccountDate DateTime not null,FBizDate DateTime,FInvAccountType Varchar(10),FQty Numeric(28,10),FAmount Numeric(28,10),primary key(FId));
Create Table T_INV_OutInventoryBill(FId Varchar(50) not null,FNumber Varchar(50) not null,FCreateDate DateTime not null,FOutDate DateTime not null,FAccountDate DateTime,FOperatorId Varchar(50) not null,FIsRedBill bit not null,FBillState Varchar(10) not null,FDescription Varchar(100),primary key(FId));
Create Table T_INV_OutInvBillDetail(FId Varchar(50) not null,FHeadId Varchar(50) not null,FMaterialId Varchar(50) not null,FMeasureUnitId Varchar(50) not null,FQty Numeric(28,10) not null,FBaseQty Numeric(28,10) not null,FBasePrice Numeric(28,10) not null,FAmount Numeric(28,10) not null,primary key(FId));
Create Table T_INV_CountInventoryBill(FId Varchar(50) not null,FNumber Varchar(50) not null,FCreateDate DateTime not null,FCountDate DateTime not null,FAccountDate DateTime,FOperatorId Varchar(50) not null,FBillState Varchar(10) not null,FDescription Varchar(100),FCountType Varchar(10) not null,primary key(FId));
Create Table T_INV_CountInvBillDetail(FId Varchar(50) not null,FHeadId Varchar(50) not null,FMaterialId Varchar(50) not null,FMeasureUnitId Varchar(50) not null,FQty Numeric(28,10) not null,FBaseQty Numeric(28,10) not null,primary key(FId));

create table T_BS_EntityInfoIndex(FId Varchar(50) not null,FName Varchar(100) not null,FPackageName Varchar(100) not null,FALias Varchar(100) not null,FTableName  Varchar(100) not null,primary key(FId))

Insert into T_BD_Person(FId,FAge,FName,FNumber) values('892E9423-C10D-E605-D4EF-EABA871FFB9D',20,'admin','admin');
Insert into T_BS_User(FId,FNumber,FPassword,FPersonId,FIsSuperAdmin,FIsFreezed) values('892E9423-C10D-E605-D4EF-EABA871FFB9D','admin','93B885ADFE0DA089CDF634904FD59F71','892E9423-C10D-E605-D4EF-EABA871FFB9D',1,0);



drop table T_BD_Person;
drop table T_BD_Material;
drop table T_BD_Supplier;
drop table T_BD_Customer;
drop table T_BD_MeasureUnitGroup;
drop table T_BD_MeasureUnit;
drop table T_BS_User;
drop table T_BS_UserPermItem;
drop table T_BS_NumberRule;
drop table T_BS_LogItem;
drop table T_BS_FilterSolution;
drop table T_INV_InInventoryBill;
drop table T_INV_InInvBillDetail;
drop table T_INV_OutInventoryBill;
drop table T_INV_OutInvBillDetail;
drop table T_INV_CountInventoryBill;
drop table T_INV_CountInvBillDetail;
drop table T_BS_EntityInfoIndex;
drop table T_INV_InvAccount;