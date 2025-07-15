# Compiler test template

The Kotlin compiler has a test framework that can be invoked externally.
It's usually used in combination with a compiler plugin;
if that's your use-case, there is [a template repository for that specifically](https://github.com/Kotlin/compiler-plugin-template).
This repository is a template for setting up just the test framework.
At the moment, only diagnostics tests are demonstrated.

To add your own diagnostics test, add a `.kt` file to `testData/diagnostics`,
using annotations to mark expected diagnostics.
Run the tests and check that the generated `.fir.diag.txt` file has the
expected contents.
