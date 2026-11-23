# ProjectLibre - Polish Translation | Polska Lokalizacja

[English](#english) | [Polski](#polski)

## Building

An example of linux build wit OpenJDK 21:

```bash
# Build the jar file
JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64 ant -f projectlibre_build/build.xml

# Build the Windows installer (needs WineHQ 10+ with i386, e.g. winehq-stable;
# Ubuntu's wine 9.0 crashes the Windows JDK: missing GetAnycastIpAddressTable)
JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64 ant -f projectlibre_build/build.xml windows-setup

# Build the Debian/Ubuntu package (projectlibre_build/packages/projectlibre_*.deb)
JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64 ant -f projectlibre_build/build.xml deb
sudo apt install ./projectlibre_build/packages/projectlibre_1.9.3-1+pl2.deb
```

## UI scaling

Linux Java only accepts whole-number `sun.java2d.uiScale` values, so the fork has its
own option for fractional steps. It enlarges fonts, rows, Gantt bars, the timescale
and column widths:

```bash
java -Dprojectlibre.fontScale=1.5 -jar projectlibre.jar
```

For the installed package, add `-Dprojectlibre.fontScale=1.2` (or `1.5`) to `JAVA_OPTS`
in `~/.projectlibre/run.conf`. Column widths and positions are saved to `.pod` files
unscaled, so a project looks the same whatever scale it was saved with.

## Budowanie

Przykład na linux z OpenJDK 21:

```bash
# Zbuduj plik jar
JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64 ant -f projectlibre_build/build.xml

# Zbuduj instalator Windows (wymaga WineHQ 10+ z i386, np. winehq-stable;
# wine 9.0 z Ubuntu wywraca Windowsowe JDK: brak GetAnycastIpAddressTable)
JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64 ant -f projectlibre_build/build.xml windows-setup

# Zbuduj pakiet Debian/Ubuntu (projectlibre_build/packages/projectlibre_*.deb)
JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64 ant -f projectlibre_build/build.xml deb
sudo apt install ./projectlibre_build/packages/projectlibre_1.9.3-1+pl2.deb
```

## Skalowanie interfejsu

Java na Linuksie przyjmuje tylko całkowite wartości `sun.java2d.uiScale`, dlatego fork ma
własną opcję dla ułamkowych skal. Powiększa czcionki, wiersze, paski Gantta, oś czasu
i szerokości kolumn:

```bash
java -Dprojectlibre.fontScale=1.5 -jar projectlibre.jar
```

W zainstalowanej paczce dopisz `-Dprojectlibre.fontScale=1.2` (lub `1.5`) do `JAVA_OPTS`
w `~/.projectlibre/run.conf`. Szerokości kolumn i pozycje zapisują się w plikach `.pod`
bez skali, więc projekt wygląda tak samo niezależnie od skali, z jaką go zapisano.

## Polski

Ten fork ProjectLibre zawiera tłumaczenie interfejsu użytkownika na język polski dla wersji 1.9.3.

### O ProjectLibre

ProjectLibre to darmowa i open-source'owa alternatywa dla Microsoft Project. Program umożliwia zarządzanie projektami, tworzenie diagramów Gantta, zarządzanie zasobami i wiele innych funkcji przydatnych w zarządzaniu projektami.

### Co zostało przetłumaczone?

- Kompletny interfejs użytkownika
- Menu i paski narzędzi

### Wymagania systemowe

- System operacyjny: Windows, Linux lub macOS
- Java Runtime Environment (JRE) - przetestowane opcje:
  - OpenJDK 8 (tu wyświetla "krzaczki" zamiast polskich znaków)
  - OpenJDK 11 (ok)
  - OpenJDK 21 (ok)

### Instalacja

1. Zainstaluj wybraną dystrybucję Java Runtime Environment (JRE)
2. Pobierz najnowszą wersję ProjectLibre z sekcji [Releases](../../releases)
3. Zainstaluj program zgodnie z instrukcjami dla Twojego systemu operacyjnego
4. Polski język będzie dostępny w menu Globus -> Language (pl) i Country (Poland)

### Oryginalny Projekt

- [Oficjalna strona ProjectLibre](https://www.projectlibre.com/)

### Licencja

Ten projekt jest dostępny na tej samej licencji co oryginalny ProjectLibre - Common Public Attribution License Version 1.0 (CPAL)

---

## English

This fork of ProjectLibre includes Polish language translation for version 1.9.3.

### About ProjectLibre

ProjectLibre is a free and open-source alternative to Microsoft Project. It enables project management, Gantt chart creation, resource management, and many other features useful in project management.

### What has been translated?

- Complete user interface
- Menus and toolbars

### System Requirements

- Operating System: Windows, Linux, or macOS
- Java Runtime Environment (JRE) - tested options:
  - OpenJDK 8 (displays incorrect Polish characters)
  - OpenJDK 11 (working correctly)
  - OpenJDK 21 (working correctly)

### Installation

1. Install your chosen Java Runtime Environment (JRE)
2. Download the latest version of ProjectLibre from the [Releases](../../releases) section
3. Install the program according to your operating system's instructions
4. Polish language will be available in Globe menu -> Language (pl) and Country (Poland)

### Original Project

- [ProjectLibre Official Website](https://www.projectlibre.com/)

### License

This project is available under the same license as the original ProjectLibre - Common Public Attribution License Version 1.0 (CPAL)
