package com.mook1594.biznavi.transactions.handler.data;

import java.util.Optional;

import com.mook1594.biznavi.common.enums.NavigationDataType;
import com.mook1594.biznavi.transactions.command.NavigationData;
import com.mook1594.biznavi.transactions.dto.BizNaviTransactionDto;
import com.mook1594.biznavi.transactions.handler.valid.ValidHandlerResolver;

public class StartNavigationDataHandler implements NavigationDataHandler {

	@Override
	public boolean isType(final NavigationDataType type) {
		return NavigationDataType.START_NAVI == type;
	}

	@Override
	public Optional<BizNaviTransactionDto> resolveNavigationData(final NavigationData navigationData,
		final Optional<BizNaviTransactionDto> dto) {

		if(ValidHandlerResolver.handle(navigationData, dto.orElse(null))) {
			return createBizNaviTransaction(navigationData);
		}
		return Optional.empty();
	}

	private Optional<BizNaviTransactionDto> createBizNaviTransaction(final NavigationData navigationData) {
		final BizNaviTransactionDto transaction = navigationData.toBizNaviTransactionDto();
		transaction.addLocationInfo(
			navigationData.toBizNaviLocationInfoDto()
		);
		return Optional.ofNullable(transaction);
	}
}
