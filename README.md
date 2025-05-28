# Convert number to lao text

# Lao Number to Text Converter

A Java utility library for converting numeric values to Lao text representation, specifically designed for monetary amounts and general number conversion.

## Overview

This library provides functionality to convert numbers (particularly monetary amounts) into their Lao language text equivalents. It's useful for applications that need to display numbers in Lao script, such as financial systems, invoicing applications, or educational tools.

## Features

- Convert numbers up to 13 digits to Lao text
- Specialized handling for monetary amounts
- Support for complex Lao numbering rules and exceptions
- Handles edge cases for number positioning and pronunciation

## Classes

### `LaoNumberToText`

Main converter class containing the conversion logic.

**Key Methods:**

- `MoneyToLakWord(String priceAmount)` - Converts a numeric string to Lao text
- `ToWord(String price)` - Wrapper method for `MoneyToLakWord`
- `listNumber()` - Returns mapping of digits (0-9) to Lao words
- `listMoney()` - Returns mapping of positional values to Lao unit words

### `NumberMo`

Model class representing digit-to-word mappings.

**Properties:**

- `num` - The numeric digit (as String)
- `word` - The corresponding Lao word

### `UnitMoneyMo`

Model class representing positional unit mappings.

**Properties:**

- `indx` - The position index (as String)
- `word` - The corresponding Lao unit word

## Usage

### Basic Usage

```java
import umoney.model.LaoNumberToText;

public class Example {
    public static void main(String[] args) {
        // Convert a number to Lao text
        String result = LaoNumberToText.MoneyToLakWord("90000000");
        System.out.println(result);

        // Alternative method
        String result2 = LaoNumberToText.ToWord("12345");
        System.out.println(result2);
    }
}
```

### Supported Number Range

- **Maximum:** 13 digits
- **Minimum:** 1 digit
- Numbers exceeding 13 digits will return "Not support"

## Lao Number Mappings

### Digits (0-9)

| Digit | Lao Word |
| ----- | -------- |
| 1     | ໜື່ງ     |
| 2     | ສອງ      |
| 3     | ສາມ      |
| 4     | ສີ່      |
| 5     | ຫ້າ      |
| 6     | ຫົກ      |
| 7     | ເຈັດ     |
| 8     | ແປດ      |
| 9     | ເກົ້າ    |
| 0     | (empty)  |

### Units/Positions

| Position | Lao Unit               |
| -------- | ---------------------- |
| 1        | (empty)                |
| 2        | ສິບ (ten)              |
| 3        | ຮ້ອຍ (hundred)         |
| 4        | ພັນ (thousand)         |
| 5        | ສິບ (ten thousand)     |
| 6        | ແສນ (hundred thousand) |
| 7        | ລ້ານ (million)         |
| 8        | ສິບ (ten million)      |
| 9        | ຮ້ອຍ (hundred million) |
| 10       | ພັນ (billion)          |
| 11       | ຕື່ (ten billion)      |
| 12       | ແສນ (hundred billion)  |
| 13       | ລ້ານລ້ານ (trillion)    |

## Special Rules and Edge Cases

The converter implements several Lao language-specific rules:

1. **Special handling for "1" in different positions**

   - Uses "ເອັດ" in certain contexts
   - Uses "ໜຶ່ງ" vs "ໜື່ງ" based on position and surrounding digits

2. **Special handling for "2" in tens position**

   - Uses "ຊາວ" instead of "ສອງ" for twenties

3. **Zero handling**

   - Complex logic for when to include or omit units when zeros are present

4. **Decimal handling**
   - Removes ".0" from input strings automatically

## Error Handling

- Returns `null` if an exception occurs during conversion
- Returns "Not support" for numbers exceeding 13 digits
- Handles malformed input gracefully

## Dependencies

- Java Standard Library only
- No external dependencies required

## Package Structure

```
umoney.model/
├── LaoNumberToText.java    # Main converter class
├── NumberMo.java          # Digit mapping model
└── UnitMoneyMo.java       # Unit mapping model
```

## Example Conversions

```java
LaoNumberToText.MoneyToLakWord("1")        // ໜື່ງ
LaoNumberToText.MoneyToLakWord("10")       // ສິບ
LaoNumberToText.MoneyToLakWord("21")       // ຊາວເອັດ
LaoNumberToText.MoneyToLakWord("100")      // ໜື່ງຮ້ອຍ
LaoNumberToText.MoneyToLakWord("1000")     // ໜື່ງພັນ
LaoNumberToText.MoneyToLakWord("90000000") // ເກົ້າຕື່ນລ້ານ
```

## Notes

- Designed primarily for Lao monetary system
- Follows traditional Lao numbering conventions
- Complex logic handles pronunciation rules specific to Lao language
- Input should be numeric strings (decimals will be truncated)

## Author

@stl_sdd_thavithong

## License

License headers indicate this follows project-specific licensing terms.
