# Stackable

[![](https://jitpack.io/v/robaertschi/stackable.svg)](https://jitpack.io/#robaertschi/stackable)

Stackable is a mod that allows People to force any Item to a specific stack size. When installed it will default to 64 for every Items (including Totems, Tools and Armor). Moddeveloper can set a Maximum stacksize that will be used. This can be disabled by the User. Moddeveloper can also print a warning if this Mod does not work correctly with there Mod. They can also set a Warning when the User forces the stacksize. These warnings can be disabled.

# **Could break some functionality of the game when you go over 64**

## Integration
ModMenu

## Dependencies
Requires Cloth Config and Fabric API
Recommended but not needed is Mod Menu

## Config
Default Config:
```toml
stackSize = 64
onlyUnstackables = false
onlyStackables = false
forceStackSize = false
turnWarningsOff = false
```

Apply the stackSize only to unstackables Items like Totems or Tools:
```toml
stackSize = 64
onlyUnstackables = true
onlyStackables = false
forceStackSize = false
turnWarningsOff = false
```
Apply only to stackables:
```toml
stackSize = 64
onlyUnstackables = false
onlyStackables = true
forceStackSize = false
turnWarningsOff = false
```
Force the stacksize to every item of a Mod that sets a Max stacksize:
```toml
stackSize = 64
onlyUnstackables = false
onlyStackables = false
forceStackSize = true
turnWarningsOff = false
```
Turn off any Warning in Chat on joining:
```toml
stackSize = 64
onlyUnstackables = false
onlyStackables = false
forceStackSize = false
turnWarningsOff = true
```

## For mod Devs.

First add jitpack to the repositories as an Repo:

```gradle
repositories {
	...
	maven { url "https://jitpack.io" }
}
```

Then in dependencies:
```gradle
dependencies {
        modImplementation 'com.github.robaertschi:stackable:${project.stackable_version}'
}
```

Then in gradle.properties:
```properties
stackable_version = version
```
Replace _version_ with the Mod Version which you find here on GitHub Rleases/Tags or on Modrinth Project Page.

Then implement IDefinedStackableItem for your Item. There could be an easier way in the Future without needing to create a complete new Item class but for now it is only this way.
