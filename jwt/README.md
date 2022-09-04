#JWT Kata
##Keys
a Keystore is available containing 2 keypairs. See `kata.tdd.jwt.KeyLoaderTest` for the aliases and passwords
##Validation
write an application that is able to validate an JWT against the following parameters
- the JWT is correctly signed
- the subject of the jwt is 'jwt'
- the audience of the jwt is 'kata'
- the issuer of the jwt is 'karel'

##Creation
write an application that is able to correctly create a signed 
- the JWT should be signed and contain the keyId header corresponding to the key
- the subject of the jwt should be 'kata'
- the audience of the jwt should be 'tdd'
- the issuer of the jwt should be 'ensemble'