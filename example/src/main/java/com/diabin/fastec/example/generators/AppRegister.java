package com.diabin.fastec.example.generators;

import com.diabin.latte_annotations.annotations.AppRegisterGenerator;
import com.diabin.latte_core.wechat.template.AppRegisterTemplate;


@AppRegisterGenerator(
        packageName = "com.diabin.fastec.example",
        registerTemplete = AppRegisterTemplate.class
)
public class AppRegister {
}
