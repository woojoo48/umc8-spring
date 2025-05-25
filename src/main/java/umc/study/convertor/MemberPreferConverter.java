package umc.study.convertor;

import umc.study.domain.FoodCategory;
import umc.study.domain.mapping.MemberPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {

    public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodCategoryList) {
        return foodCategoryList.stream()
                .map(foodCategory ->
                        MemberPrefer.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }

    public static MemberPrefer toMemberPrefer(FoodCategory foodCategory) {
        return MemberPrefer.builder()
                .foodCategory(foodCategory)
                .build();
    }
}