# Daffodil 26.3 port

This project targets Minecraft 26.3 with NeoForge 26.3.0.101, ModDevGradle 2.0.148, Gradle 9.2.1, and Java 25.

## Build and launch

- Open `v26.3` as the Gradle project in IntelliJ IDEA.
- Run `gradlew build` to produce the mod jar.
- Run `gradlew runClient` for a local client, or `gradlew runServer` for a local server.
- Run `gradlew runData` to generate data resources.

The 1.20.1 project remains under `../v1.20.1` as a separate project.

## Ported so far

- Deferred registration for blocks, items, entities, block entities, and the creative tab, with explicit 26.3 registry IDs on block and item properties.
- 26.3 worldgen feature, placed feature, biome modifier, and tree grower formats.
- NeoForge block-transformer data map for plum log stripping.
- Native `BoatItem` placement for the plum boat and chest boat, with custom entity renderers using the 26.3 submission renderer API.
- NeoForge client registration for banner, sign, and boat renderers. The vanilla loom screen is retained.
- 26.3 generated `neoforge.mods.toml` metadata and resource pack format metadata.
- Singular 1.21+ resource directory names and the current 26.3 recipe/tag formats.

## World generation fixes

- Plum logs and wood are included in `minecraft:prevents_nearby_leaf_decay`, which keeps plum and flowering plum leaves attached. The wood variants are also in the vanilla log tags, and both leaf blocks are in `minecraft:leaves`.
- Hibiscus is a weighted entry in vanilla's `minecraft:moss_vegetation` feature, so it generates in the same lush-cave patches as moss carpet, grass, and azaleas. Its weight is 3 to retain the requested increased frequency.

## Known follow-up work

`compileJava` succeeds. The dedicated server loads the datapacks and reaches `Done` without registry, tag, recipe, or feature parsing errors. Actual in-world checks in lush caves are still needed. New vegetation appears only in unexplored chunks; existing chunks are not retroactively populated. Many Daffodil item models still need conversion to the 26.3 item model format. The custom RGB banner rendering and loom preview also need a RenderPearl-era implementation; vanilla rendering is currently used. Bed models and the remaining assets need gameplay validation.