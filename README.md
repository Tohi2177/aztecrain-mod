# 🌧️ Aztec Rain

*Perform sacred sacrifices to command the sky.*  
A Fabric mod for Minecraft 1.21.1, written in modern Kotlin.

---

## 🪔 Overview

**Aztec Rain** is a ritualistic magic mod inspired by Aztec mythology.  
Slay pigs on sacred altars using the *Ceremonial Knife* to change the weather —  
call the rain, clear the skies, or summon thunder, depending on the ritual.

🔮 Features:
- Custom advancement tree
- Ritual detection system (platforms + candles)
- Unique weather-manipulation mechanics
- Custom sound, particles, and status effects
- Fully written in **Kotlin 2.1**, powered by **Fabric API**

---

## 🚀 Getting Started

### Prerequisites

- Minecraft `1.21.1`
- Fabric Loader `>=0.16.14`
- Java `21`
- Kotlin `2.1.21`

### 💻 Dev Setup

1. Clone the repo:
	```bash
	git clone https://github.com/YOUR_USERNAME/aztec-rain.git
	cd aztec-rain
	```
2. Import into IntelliJ IDEA:
	* Open as **Gradle Kotlin (KTS)** project
	* Use the **Java 21** toolchain
3. Build with:
	```bash
	./gradlew build
	```
4. Run client (optional):
	```bash
	./gradlew runClient
	```

---

## 🔧 Mod Mechanics

* Craft the **Ceremonial Knife** using copper, lapis, and a stick.
* Build a **3×3 smooth stone platform** with **lit candles on each corner**.
* Sacrifice a **pig** on the altar:
	* If you *already* have the **Grace** effect → ⚡ thunderstorm
	* If it’s raining → ☀️ clears weather
	* If it’s clear → 🌧️ starts rain
	* You gain **Grace** on your first ritual

---

## 📁 Project Structure

```plaintext
📦 aztecrain/
├── src/main/kotlin/...     # Mod logic, event hooks, and systems
├── src/main/resources/     # mod metadata, assets, mixins
├── build.gradle.kts        # Kotlin DSL Gradle config
├── gradle.properties       # Mod + build config
├── LICENSE.txt             # NFE-OSL license
└── README.md               # You are here
```

---

## ✨ Highlights

* ⚙️ Uses **Fabric Loom** + **Kotlin Gradle plugin**
* 🧪 Modular OOP design
* 🎨 Particle effects + subtitles
* 📜 Custom criteria & advancement triggers
* 📦 DataGen for lang, models, recipes, advancements

---

## 🧑‍💻 Developer Notes

* Kotlin 2.1+ with `jvmTarget = 21`
* Mixins written in Java (`mixin/LivingEntityMixin.java`)
* Fabric Data API is used for runtime and generation logic
* Everything is modularized via `Mod*` registries

---

## 📜 License

This project is licensed under the
**Nolly’s Fair & Ethical Open‑Source License (NFE‑OSL v1.0)**.
See [`LICENSE.txt`](./LICENSE.txt) for full terms.

🛡️ TL;DR:

* ✅ Free & open-source for ethical use
* ⚠️ Attribution required
* ❌ No military/surveillance/closed-source commercial use
* 📬 Contact [nolly.berrebi@gmail.com](mailto:nolly.berrebi@gmail.com) for commercial licenses

---

## 💖 Support This Mod

Aztec Rain is a labor of love by [Nolly](https://cafe.thenolle.com) — built solo, open-source, and with care.  
If you enjoy the mod or want to see more mythic mechanics in Minecraft, consider supporting:

- 💸 [Sponsor on GitHub](https://github.com/sponsors/thenolle)
- ☕ [Buy me a coffee](https://ko-fi.com/nollycafe)
- 🌐 [More ways to support](https://cafe.thenolle.com/sponsor)

Your support helps fund new features, bug fixes, and future magical projects.  
Thank you for keeping the ritual alive 🕯️

---

## 🧙 Credits

* 🔮 Mod created by [Nolly](https://cafe.thenolle.com)
* 💡 Idea by \[zelimonster]
* Made with ♥ in Kotlin

---

## 🧪 Try It Out

1. Drop the built `.jar` from `build/libs/` into `.minecraft/mods/`
2. Launch with Fabric 1.21.1

---

> *"Rituals echo through the skies. The knife remembers."*
