## Generate key

keytool -genkeypair -alias timeline -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore timeline.p12 -validity 3650

Add to: src/main/resources/keystore/
