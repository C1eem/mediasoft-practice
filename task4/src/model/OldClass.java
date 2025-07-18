package model;

import annotations.DeprecatedEx;

@DeprecatedEx(message = "Используйте NewClass вместо этого")
public class OldClass {
    @DeprecatedEx(message = "Используйте newMethod()")
    public void oldMethod() {}
}