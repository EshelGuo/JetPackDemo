package com.eshel.jetpack.jump;

import com.eshel.jetpack.paging.ImageActivity;
import com.eshel.jump.JumpHelper;
import com.eshel.jump.anno.Intent;

/**
 * createBy Eshel
 * createTime: 2019/5/31 14:57
 */
public interface Jump {
	@Intent(target = ImageActivity.class)
	void jumpImageAct();

	Jump instance = JumpHelper.create(Jump.class);
	static Jump get(){
		return instance;
	}
}
