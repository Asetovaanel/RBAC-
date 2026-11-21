# VS Code-та іске қосу

JDK 17 және Maven орнатылған компьютерде VS Code арқылы `pom.xml` бар папканы аш. Terminal → New Terminal таңда.

```powershell
mvn test
mvn package
java -cp target/classes com.example.rbac.Main
```

Соңғы команда төрт тексеруді көрсетеді. Әр жолдың басында UTC уақыты жазылады.

| Пайдаланушы | Рөл | Сұраныс | Нәтиже |
|---|---|---|---|
| demo-user | USER | READ | ALLOWED |
| demo-user | USER | DELETE | DENIED |
| demo-manager | MANAGER | READ | ALLOWED |
| demo-admin | ADMIN | DELETE | ALLOWED |

USER оқи алады. MANAGER сол рұқсатты мұраға алады және жазба енгізіп, өзгерте алады. ADMIN барлық бес рұқсатқа ие. Рөлді кітапхананы шақыратын сенімді бағдарлама тағайындайды. Журнал жедел жадта сақталады. Бағдарлама жабылғанда журнал тазарады.

## Құпия деректер

Демоға пароль, токен және жеке кілт қажет емес. `.env.example` файлына ойдан алынған пайдаланушы аты жазылған. Қажет болса, PowerShell терезесінде атты ауыстыр:

```powershell
$env:RBAC_DEMO_USER = 'student-01'
java -cp target/classes com.example.rbac.Main
```

Java мәнді процесс ортасынан оқиды. `.env` файлын автоматты түрде жүктемейді. `.gitignore` ережелерін ойдан алынған файл атауларымен тексер:

```powershell
git check-ignore -v -- .env .env.local secrets/demo.txt private.key
git ls-files -- .env .env.local secrets/ private.key
```

Бірінші команда әр атауды жасыратын ережені көрсетеді. Екінші команданың нәтижесі бос болуы тиіс. Оқу мысалына тек `.env.example` қосылады. Коммит алдында VS Code-та Staged Changes тізімін тексер.
