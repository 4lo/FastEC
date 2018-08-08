package com.diabin.fastec.example.generators;

import com.diabin.latte_annotations.annotations.EntryGenerator;
import com.diabin.latte_core.wechat.template.WXEntryTemplate;

@EntryGenerator(
        packageName = "com.diabin.fastec.example",
        entryTemplete = WXEntryTemplate.class
)
public interface WeChatEntry {

}
