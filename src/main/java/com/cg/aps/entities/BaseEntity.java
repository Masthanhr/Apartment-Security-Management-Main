package com.cg.aps.entities;

import java.sql.Timestamp;

public abstract class BaseEntity implements DropdownList {

	protected long id;
	protected String createdBy;
	protected String modifiedBy;
	protected Timestamp createdDateTime;
	protected Timestamp modifiedDateTime;

}
