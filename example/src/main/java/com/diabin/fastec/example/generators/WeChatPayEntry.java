package com.diabin.fastec.example.generators;


import com.diabin.latte_annotations.annotations.PayEntryGenerator;
import com.diabin.latte_core.wechat.template.WXPayEntryTemplate;

@PayEntryGenerator(
        packageName = "com.diabin.fastec.example",
        payEntryTemplete = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {
}
