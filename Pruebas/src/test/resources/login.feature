Feature: Validación del formulario Popup

  Scenario Outline: Validar el formulario Popup con diferentes datos
    Given que estoy en la página de formulario Popup
    When diligencio el formulario Popup con los siguientes datos:
      | Campo               | Valor            |
      | Campo Required      | <required>       |
      | Campo Select        | <select>         |
      | Campo MultipleSelect| <multipleSelect> |
      | Campo URL           | <url>            |
      | Campo Email         | <email>          |
      | Campo Password      | <password>       |
      | Campo MinimumFieldSize | <minimumFieldSize> |
      | Campo MaximumFieldSize | <maximumFieldSize> |
      | Campo Number        | <number>         |
      | Campo IP            | <IP>             |
      | Campo Date          | <date>           |
      | Campo DateEarlier   | <dateEarlier>    |
    And hago clic en el botón de envío
    Then el formulario Popup se valida correctamente

    Examples:
      | required | select   | multipleSelect | url                 | email                 | password       | minimumFieldSize | maximumFieldSize | number      | IP            | date        | dateEarlier  |
      | Hello    | Tennis   | Tennis, Football| http://example.com  | hello@gmail.com       | password123    | 12345            | 99999            | 123.456    | 192.168.0.1   | 2023-05-22  | 2010-01-15   |
      | World    | Football | Tennis, Golf   | http://example.com  | world@gmail.com       | pass123         | 67890            | 88888            | 987.654    | 10.20.30.40   | 2023-05-23  | 2015-06-30   |
      | Java     | Golf     | Tennis, Football| http://example.com  | java@gmail.com        | secret          | 13579            | 77777            | 543.210    | 172.16.0.1    | 2023-05-24  | 2005-12-01   |
      | Programming | Tennis | Golf, Football | http://example.com  | programming@gmail.com | p@ssw0rd        | 24680            | 66666            | 987.123    | 192.168.1.1   | 2023-05-25  | 2018-09-10   |


Feature: Validación del formulario Block

  Scenario Outline: Validar el formulario Block con diferentes datos
    Given que estoy en la página de formulario Block
    When diligencio el formulario Block con los siguientes datos:
      | Campo               | Valor            |
      | Campo Required      | <required>       |
      | Campo Email         | <email>          |
      | Campo Password      | <password>       |
      | Campo ConfirmPassword | <confirmPassword> |
      | Campo Date          | <date>           |
      | Campo URL           | <url>            |
      | Campo DigitsOnly    | <digitsOnly>     |
      | Campo Range         | <range>          |
    And hago clic en el botón de envío
    Then el formulario Block se valida correctamente

    Examples:
      | required | email            | password   | confirmPassword | date       | url                  | digitsOnly | range |
      | Hello    | hello@gmail.com  | pass123    | pass123         | 2023-05-22 | http://example.com   | 123456789  | 8     |
      | World    | world@gmail.com  | secret     | secret          | 2023-05-23 | http://example.com   | 987654321  | 10    |
      | Java     | java@gmail.com   | p@ssw0rd   | p@ssw0rd        | 2023-05-24 | http://example.com   | 543216789  | 12    |
      | Programming | programming@gmail.com | 12345678  | 12345678   | 2023-05-25 | http://example.com   | 987654321  | 6     |


Feature: Validación del formulario Inline

  Scenario Outline: Validar el formulario Inline con diferentes datos
    Given que estoy en la página de formulario Inline
    When diligencio el formulario Inline con los siguientes datos:
      | Campo               | Valor            |
      | Campo Required      | <required>       |
      | Campo Email         | <email>          |
      | Campo Password      | <password>       |
      | Campo ConfirmPassword | <confirmPassword> |
      | Campo Date          | <date>           |
      | Campo URL           | <url>            |
      | Campo CharsMin3     | <charsMin3>      |
      | Campo CharsMax6     | <charsMax6>      |
      | Campo Min3          | <min3>           |
      | Campo Max16         | <max16>          |
    And hago clic en el botón de envío
    Then el formulario Inline se valida correctamente

    Examples:
      | required | email            | password   | confirmPassword | date       | url                  | charsMin3 | charsMax6 | min3 | max16      |
      | Hello    | hello@gmail.com  | pass123    | pass123         | 2023-05-22 | http://example.com   | abc       | abcdef   | 123  | 0.123456   |
      | World    | world@gmail.com  | secret     | secret          | 2023-05-23 | http://example.com   | def       | abc      | 456  | 0.789012   |
      | Java     | java@gmail.com   | p@ssw0rd   | p@ssw0rd        | 2023-05-24 | http://example.com   | ghi       | abcdef   | 789  | 0.345678   |
      | Programming | programming@gmail.com | 12345678  | 12345678   | 2023-05-25 | http://example.com   | jkl       | abc      | 1234 | 0.901234   |
