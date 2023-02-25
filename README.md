# Devsavant_Android_networking_challenge

This repo is in response of this Devsavant challange https://github.com/devsavant/Android_networking_challenge

## Architecture:
- Implement a clean architecture based on Robert C Martin's Book, where layers are kept isolated for better code scalability.
- Apply S.O.L.I.D principles to maintain project efficiency and scalability
- MVVM for the presentation layer

[![N|Clean](https://blog.cleancoder.com/uncle-bob/images/2012-08-13-the-clean-architecture/CleanArchitecture.jpg)]


# DEMO:
demo.mp4 is located on root directory

# Technologies and tools:
- HILT: For dependency injection use
- Retrofit: consume the API
- Compose: build the UI
- Coroutines: for background work


#Final considerations
- I just did a single View model test because it was the main and more complex class in this challenge, in a production app I would test all classes, but for this challenge I consider it is sufficient to demostrate in that class
- I didnt use different modules as you can see in my other projects, because this one was smaller, but I kept the separation of the layers beteweeen data, domain and presentation.
- I let the API url in the code since this is a challenge , in a production app I would move it to the gradle and obfuscate the code.
